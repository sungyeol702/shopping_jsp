async function getCommentListFromServer(pno) {
    try {
        const resp = await fetch('/revp/plist/' + pno);
        const revList = await resp.json();
        return await revList;
    } catch (error) {
        console.log(error);
    }
}
function spreadReviewList(result) {
    let div = document.getElementById("content");
    div.innerText = "";
    for (let i = 0; i < result.length; i++) {
        let html = `<div class="customer-review-option">
        <h4><a href="/rev/detail?rno=${result[i].rno}">${result[i].title}</a></h4>
        <div class="comment-option">
            <div class="co-item">
                <div class="avatar-pic">
                    <img src="/_fileUpload/th_${result[i].image_file}" alt="">
                </div>
                <div class="avatar-text">
                    <h5>
                    ${result[i].writer} <span>${result[i].reg_at}</span>
                    </h5>
                    <div class="at-reply">${result[i].description}</div>
                </div>
            </div>
        </div>
    </div>`;
    div.innerHTML += html;
    }
}

document.getElementById('reviewBtn').addEventListener('click',()=>{
    const pno = document.getElementById("pno").innerText;
    let pnoVal = pno.substring(pno.lastIndexOf(':') + 2);
    console.log(pnoVal);
    getCommentListFromServer(pnoVal).then(result => {
        console.log(result);
        if (result.length > 0) {
            spreadReviewList(result);
        }else{
            let div = document.getElementById("content");
            div.innerHTML = 'Review가 존재하지 않습니다.';
        }
    })


})
function spreadDescription(){
    let div = document.getElementById('content');
    div.innerHTML = `<div class="tab-item-content">
    <div class="tab-content">
        <div class="tab-pane fade-in active" id="tab-1" role="tabpanel">
            <div class="product-content">
                <div class="row">
                    <div class="col-lg-7">
                        <h5>Introduction</h5>
                        <p>>${description}</p>
                    </div>
                    <div class="col-lg-5">
                        <img src=">resources/dist/img/product-single/tab-desc.jpg"
                            alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>`;
}

document.getElementById("descriptionBtn").addEventListener('click',()=>{
    spreadDescription();
});