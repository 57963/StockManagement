function setup(){
    var canvas = createCanvas(100,100);
    canvas.parent('sketch');
}

function draw(){
    ellipse(mouseX,mouseY,50,50);
}