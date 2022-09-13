//댓글리스트
async function getCommentListFromServer(bno) {
  try {
    const resp = await fetch('/cmt/list/' + bno);
    const cmtList = await resp.json();
    return await cmtList;
  } catch (error) {
    console.log(error);
  }
}
function spreadCommentList(result) {
  let div = document.getElementById("commentBox");
  div.innerText = "";
  for (let i = 0; i < result.length; i++) {
    let html = `<div class="posted-by row">
    <div class="col-sm-2">${result[i].writer}</div>
    <div class="pb-text col-sm-7">
    ${result[i].content}
    </div>
    <div class="pb-text col-sm-2">
    ${result[i].reg_at}
    </div>
    <div class="pb-text col-sm-1">`;
   html += `<button type="button" class="btn btn-danger" data-cno="${result[i].cno}" id="cmtDelBtn">x</button>`;
   html +='</div></div>';
    div.innerHTML += html;
  }
}
function printCommentList() {
  const bno = document.getElementById("bno").innerText
  let bnoVal = bno.substring(0, bno.lastIndexOf("."));
  getCommentListFromServer(bnoVal).then(result => {
    if (result.length > 0) {
      spreadCommentList(result);
    } else {
      let div = document.getElementById("commentBox");
      div.innerHTML = 'Comment가 존재하지 않습니다.';
    }
  })
}
//댓글등록
async function postCommentToServer(cmtData) {
try {
  const url = "/cmt/post";
  const config = {
    method : 'post',
    headers : {
      'content-type' : 'application/json; charset=utf-8'
    },
    body : JSON.stringify(cmtData)
  };
  const resp = await fetch(url,config);
  const result =await resp.text();
  return result;
} catch (error) {
  console.log(error);
}
}

document.getElementById('cmtPostBtn').addEventListener('click',()=>{
  const cmtText = document.getElementById('cmtText').value;
  const bno = document.getElementById("bno").innerText
  let bnoVal = bno.substring(0, bno.lastIndexOf("."));
  if(cmtText == null || cmtText == ''){
    alert('댓글 내용을 입력해 주세요');
    return false;
  }else{
    let cmtData = {
      bno : bnoVal,
      writer : document.getElementById('writer').value,
      content : cmtText
    };
    postCommentToServer(cmtData).then(result => {
      if(result > 0) {
        alert('댓글 등록 성공!');
        document.getElementById('cmtText').value = "";
      }
      printCommentList();
    });
  }
});
//댓글 삭제
async function removeCommentFromServer(cnoVal){
  try {
    const url = '/cmt/remove/'+cnoVal;
    const config = {
      method: 'post'
    }
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  } catch {
    console.log(error);
  }
}

document.addEventListener('click', (e) => {
  if(document.querySelector('#cmtDelBtn').contains){
    let cnoVal = e.target.dataset.cno;
    removeCommentFromServer(cnoVal).then(result => {
      if(result > 0) {
        alert("댓글 삭제 성공!");
        printCommentList();
      }
    });
  }
});
