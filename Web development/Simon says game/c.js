//Print constant highest score

let gameSeq = [];
let userSeq = [];
let started = false;
let level = 0;
let btns = ["yellow", "red", "purple", "green"];
let h2 = document.querySelector("h2");
document.addEventListener("keypress", function(){
    if(started == false){
        console.log("game started");
        started = true;
    }

    levelup();
});


function gameFlash(btn){
    btn.classList.add("flash");
    setTimeout(function(){
        btn.classList.remove("flash");
    },300);
}
function userFlash(btn){
    btn.classList.add("userflash");
    setTimeout(function(){
        btn.classList.remove("userflash");
    },100);
}
function levelup(){
    userSeq = [];                                                   //reset user seq for every level
    level++;
    h2.innerText = `Level ${level}`;
    let ranidx = Math.floor(Math.random() * 3 );
    let rancol = btns[ranidx];
    let ranbtn = document.querySelector(`.${rancol}`);
    gameSeq.push(rancol);
    console.log(gameSeq);
    gameFlash(ranbtn);
}

function checkAns(idx){
    if(userSeq[idx] == gameSeq[idx]){
        if(userSeq.length == gameSeq.length){
            setTimeout(levelup, 1000);
        }
    } else{
        h2.innerText = `Game Over. Press any key to restart`;
        document.querySelector("body").style.backgroundColor = "red";
        setTimeout(function (){
            document.querySelector("body").style.backgroundColor = "white";
        }, 200)
        reset();
    }
}

function btnpress(){
    let btn = this;
    userFlash(btn);

    usercol = btn.getAttribute("id");
    userSeq.push(usercol);

    checkAns(userSeq.length - 1);


}

let allbtns = document.querySelectorAll(".btn");
for(btn of allbtns){
    btn.addEventListener("click", btnpress);
}

function reset(){
    started = false;
    gameSeq = [];
    userSeq = [];
    level = 0;
}



