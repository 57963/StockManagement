var canvas;
var selectedLoc = 0;
function setup() {
    canvas = createCanvas(document.getElementById("profitGraph").offsetWidth,document.getElementById("profitGraph").offsetHeight);
    canvas.parent("profitGraph");
    colorMode(HSB);
    textAlign(CENTER,CENTER);
    textFont("Arial");
}

function resize() {
    canvas.size(document.getElementById("profitGraph").offsetWidth,document.getElementById("profitGraph").offsetHeight);
}

function draw() {
    background(100);
    noStroke();
    fill(0);
    text("Week(2016)",width/2,height-5);
    stroke(0);
    line(10,10,10,height-20);
    line(10,height-20,width-10,height-20);
    for(var x = 0; x<53;x++){
        if(x%10 == 0){
            noStroke();
            text(x,map(x,0,52,10,width-10),height-10);
        }
        stroke(70);
        line(map(x,0,52,10,width-10),10,map(x,0,52,10,width-10),height-20);
    }
    for(var y = 0; y<=10;y++){
        noStroke();
        push();
        translate(5,map(y,0,10,height-20,10));
        rotate(-HALF_PI);
        text(map(y,0,10,0,height-30),0,0);
        pop();
        stroke(70);
        line(10,map(y,0,10,height-20,10),width-10,map(y,0,10,height-20,10));
    }

    for(var i = 1 ; i< locLength+1; i++){
        if(i==selectedLoc){
            strokeWeight(5);
        } else{
            strokeWeight(1);
        }
        fill((i)*(255.0/(locLength+1)),45,77);
        stroke((i)*(255.0/(locLength+1)),45,77);
        var pX = 0;
        var pY = 0;
        for(var week = 1; week<locations[i].weeks+1;week++){
            line(map(pX,0,52,10,width-10),height-20-pY,map(week,0,52,10,width-10),height-20-locations[i].sales[week].net);
            ellipse(map(week,0,52,10,width-10),height-20-locations[i].sales[week].net,5,5);
            pX=week;
            pY=locations[i].sales[week].net;
        }
    }
    strokeWeight(1);
}

function mouseClicked(){
    for(var i = 1 ; i< locLength+1; i++) {
        for (var week = 1; week < locations[i].weeks + 1; week++) {
            if (dist(mouseX, mouseY, map(week, 0, 52, 10, width - 10), height - 20 - locations[i].sales[week].net) < 10) {
                if (i == selectedLoc) {
                    selectedLoc = 0;
                } else {
                    selectedLoc = i;
                }
            }
        }
    }
}