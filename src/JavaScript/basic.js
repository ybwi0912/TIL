// js 영역

alert("javascript입니다.")

// 첫 번째 버튼이 클릭되었을 때 호출될 함수
function btn1Check(e){
    // 방법 1
    e.target.style.backgroundColor="red";
    e.target.style.color="white";

    // 방법 2 : 정확하게 btn을 찾아와서 지정
    document.querySelector("#btn").style.fontSize="30px";
    document.querySelector("#btn").style.border="3px blue solid"
}

// 3개의 버튼이 각각 클릭되었을 때 공통으로 사용하는 함수
function btnFun(){
    // alert("클릭되었습니다.");
    console.log("버튼!");
}