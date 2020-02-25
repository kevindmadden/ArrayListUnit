//beginning for clear text: https://stackoverflow.com/questions/15661339/how-do-i-fix-blurry-text-in-my-html5-canvas
var PIXEL_RATIO = (function () {
    var ctx = document.createElement("canvas").getContext("2d"),
        dpr = window.devicePixelRatio || 1,
        bsr = ctx.webkitBackingStorePixelRatio ||
            ctx.mozBackingStorePixelRatio ||
            ctx.msBackingStorePixelRatio ||
            ctx.oBackingStorePixelRatio ||
            ctx.backingStorePixelRatio || 1;

    return dpr / bsr;
})();


createHiDPICanvas = function(w, h, ratio) {
    if (!ratio) { ratio = PIXEL_RATIO; }
    var can = document.getElementById("canvas")
    can.width = w * ratio;
    can.height = h * ratio;
    can.style.width = w + "px";
    can.style.height = h + "px";
    can.getContext("2d").setTransform(ratio, 0, 0, ratio, 0, 0);
    return can;
}

//Create canvas with the device resolution.
let canvas = createHiDPICanvas(1000, 250);

//let canvas = document.getElementById("canvas");
let ctx = canvas.getContext("2d");
const CANVAS_WIDTH = canvas.width;
const CANVAS_HEIGHT = canvas.height;
//Do not edit stuff above

//-------------------------------------------
//********** Default Canvas State ***********
ctx.lineWidth = 4
ctx.fillStyle = "blue"
ctx.strokeStyle = "aqua"
ctx.save() // SAVE Default Canvas State
//*******************************************
//-------------------------------------------

let prevTimeStamp = 0

class ArrayListAnimation {
    isAnimating = false
    isShifting = false
    indexAddedAt = 0

    length = 0
    elements = []
    initialAdd(element){
        this.elements.push(element)
    }
    add(element){
        this.elements.push(element)
        this.isShifting = true
    }
    addAt(index, element){
        this.elements.splice(index,0, element)
        this.isShifting = true
        this.indexAddedAt = index
    }
    get(index){
        return this.elements[index]
    }
    set(index, element){
        let replacedElement = this.elements[index]
        this.elements[index] = element
        return replacedElement
    }
    remove(index){
        let replacedElement = this.elements[index]
        this.elements.splice(index, 1)
    }

    squareSize = 40
    squarePadding = 5
    draw(){
        let squareSize = this.squareSize
        let squarePadding = this.squarePadding
        let originalArrayList = this.elements
        let offset = 0
        if(this.isShifting){
            originalArrayList = this.elements.splice(this.indexAddedAt,1)
        }
        for(let i = 0; i<originalArrayList.length; i++){
            let xPosGrid = i*(this.squareSize+this.squarePadding*2)
            let xPosGridCenter = xPosGrid+(this.squareSize+this.squarePadding*2)*0.5

            ctx.fillStyle = "#92fffc"
            ctx.fillRect(xPosGrid+this.squarePadding,this.squarePadding+70,this.squareSize,this.squareSize)
            ctx.fillStyle = "black"
            ctx.textAlign = "center";
            ctx.font = "15px Roboto";
            ctx.fillText(originalArrayList[i].value, xPosGridCenter, 100); //element value
            ctx.fillText(i.toString(), xPosGridCenter, 60); //index number
            console.log("drawing index number: "+i)
        }
    }

}

class ArrayListElement {
    value = "test"
    generateRandomNumber = false
    constructor(value){
        this.value = value
    }
}

const ArrayList = new ArrayListAnimation()
for(let i=0; i<20; i++){
    let precision = 100; // 2 decimals
    let randomNum = Math.floor(Math.random() * (10 * precision - 1 * precision) + 1 * precision) / (1*precision)
    let element = new ArrayListElement(randomNum)
    ArrayList.initialAdd(element)
}



let isMouseDown = false

window.requestAnimationFrame(gameLoop)

function gameLoop(currentTimeStamp){
    let timeElapsed = (currentTimeStamp - prevTimeStamp)/1000
    ctx.clearRect(0,0,1000,400)

    ArrayList.draw()

    window.requestAnimationFrame(gameLoop)
}



function isPointInRect(xPoint, yPoint, xPosTopLeftRect,
                       yPosTopLeftRect, rectWidth, rectHeight){
    if(yPoint < yPosTopLeftRect + rectHeight && yPoint > yPosTopLeftRect && xPoint < xPosTopLeftRect + rectWidth && xPoint > xPosTopLeftRect){
        return true
    }
    return false
}

function didRectCollideWithRect(xRect1, yRect1, widthRect1, heightRect1,
                                xRect2, yRect2, widthRect2, heightRect2){
    //top left point of rect1 - check if in rect2
    let didTopLeftPointCollide = isPointInRect(xRect1, yRect1, xRect2, yRect2, widthRect2, heightRect2)
    //top right point of rect1
    let didTopRightPointCollide = isPointInRect(xRect1+widthRect1, yRect1, xRect2, yRect2, widthRect2, heightRect2)
    //bottom left point of rect1
    let didBottomLeftPointCollide = isPointInRect(xRect1, yRect1+heightRect1, xRect2, yRect2, widthRect2, heightRect2)
    //bottom right point of rect1
    let didBottomRightPointCollide = isPointInRect(xRect1+widthRect1, yRect1+heightRect1, xRect2, yRect2, widthRect2, heightRect2)

    if(didTopLeftPointCollide || didTopRightPointCollide || didBottomLeftPointCollide || didBottomRightPointCollide){
        return true
    }
    return false

}





// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Mouse/Cursor Input
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

let xCursorPos = 0
let yCursorPos = 0

function getCursorPosition(canvas, event) {
    const rect = canvas.getBoundingClientRect()
    xCursorPos = event.clientX - rect.left
    yCursorPos = event.clientY - rect.top
    document.getElementById("coordinateValues").innerHTML = "Coordinates - x: "+xCursorPos+", y: "+yCursorPos
}

canvas.addEventListener('mousemove', function(e) {
    getCursorPosition(canvas, e)
})

canvas.addEventListener('mousedown', function(e) {
    getCursorPosition(canvas, e)
    isMouseDown = true
})


// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
// Keyboard Input
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

canvas.addEventListener('keydown', keyHandler)
canvas.addEventListener('keyup', keyHandler)

let kbInput = {
    left : {
        value : "ArrowLeft",
        isPressed: false,
    },
    right : {
        value : "ArrowRight",
        isPressed: false,
    },
    down : {
        value : "ArrowDown",
        isPressed: false,
    },
    up : {
        value : "ArrowUp",
        isPressed: false,
    },
}

function keyHandler(event) {
    event.preventDefault()
    let type = event.type
    let isPressed = false
    if(type==="keydown"){
        isPressed = true
    }
    if(event.key===kbInput.left.value){
        kbInput.left.isPressed = isPressed
    }
    if(event.key===kbInput.right.value){
        kbInput.right.isPressed = isPressed
    }
    if(event.key===kbInput.up.value){
        kbInput.up.isPressed = isPressed
    }
    if(event.key===kbInput.down.value){
        kbInput.down.isPressed = isPressed
    }
}