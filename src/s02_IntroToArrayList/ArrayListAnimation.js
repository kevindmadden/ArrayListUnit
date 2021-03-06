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
let canvas = createHiDPICanvas(1000, 200);

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
    xShiftDist = 0
    xVel = 30
    yShiftDist = 0
    yVel = 30
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
        console.log("Top of addAt method")
        console.log(this.elements)
        console.log("splice method")
        this.elements.splice(index,0, element)
        console.log(this.elements)
        this.indexAddedAt = index
        this.isShifting = true
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
    getXPosGrid(index, includeAnimatingShiftInGridPos=true){
        let leftGridXPos = index*(this.squareSize+this.squarePadding*2)
        if(includeAnimatingShiftInGridPos && this.isShifting && index > this.indexAddedAt){
            leftGridXPos = (index-1)*(this.squareSize+this.squarePadding*2) //when new element is first added, the leftGridXPos needs to slowly shift to the right from its previous index position of index-1
            leftGridXPos = leftGridXPos + this.xShiftDist
        }
        return {
            left: leftGridXPos,
            center: leftGridXPos + (this.squareSize + this.squarePadding * 2) * 0.5,
        }
    }
    draw(timeElapsed){
        let squareSize = this.squareSize
        let squarePadding = this.squarePadding
        if(this.isShifting){
            if(this.xShiftDist >= this.squareSize+this.squarePadding*2){
                this.isShifting = false
                this.xShiftDist = 0
                this.yShiftDist = 0
            }else{
                this.xShiftDist = this.xShiftDist + this.xVel*timeElapsed
                this.yShiftDist = this.yShiftDist + this.yVel*timeElapsed
            }
        }
        for(let i = 0; i<this.elements.length; i++){

            let xPosGrid = this.getXPosGrid(i)
            let yPos = 70


            if(this.isShifting && this.indexAddedAt===i){
                yPos = 70+50-this.yShiftDist
            }
            ctx.fillStyle = "#92fffc"
            ctx.fillRect(xPosGrid.left+this.squarePadding,this.squarePadding+yPos,this.squareSize,this.squareSize)
            ctx.fillStyle = "black"
            ctx.textAlign = "center";
            ctx.font = "15px Roboto";
            ctx.fillText(this.elements[i].value, xPosGrid.center, yPos+30); //element value
        }

        //draws index numbers
        for(let i = 0; i<this.elements.length; i++){
            let xPosGrid = this.getXPosGrid(i,false)
            if(this.isShifting && i===this.elements.length-1){
                ctx.fillStyle = "red"
                ctx.globalAlpha = (this.xShiftDist/(this.squareSize+this.squarePadding*2));
                ctx.fillText(i.toString(), xPosGrid.center, 60); //index number
                ctx.globalAlpha = 1
            }else{
                ctx.fillStyle = "black"
                ctx.fillText(i.toString(), xPosGrid.center, 60); //index number
            }

        }
    }

}

class ArrayListElement {
    //value = "test"
    //generateRandomNumber = false
    constructor(value){
        this.value = value
    }
}

const ArrayList = new ArrayListAnimation()
function generateArrayListElementRandDecNum(){
    let precision = 100; // 2 decimals
    let randomNum = Math.floor(Math.random() * (10 * precision - 1 * precision) + 1 * precision) / (1*precision)
    return new ArrayListElement(randomNum)
}
for(let i=0; i<7; i++){
    ArrayList.initialAdd(generateArrayListElementRandDecNum())
}



let isMouseDown = false

window.requestAnimationFrame(gameLoop)

function gameLoop(currentTimeStamp){
    let timeElapsed = (currentTimeStamp - prevTimeStamp)/1000
    prevTimeStamp = currentTimeStamp
    ctx.clearRect(0,0,1000,400)

    ArrayList.draw(timeElapsed)

    window.requestAnimationFrame(gameLoop)
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


// Buttons
function buttonAddElementAt(){
    let inputVal = document.getElementById("addAtThisIndex").value
    ArrayList.addAt(Number(inputVal),generateArrayListElementRandDecNum())

    resetGetElementSpace()
}

function buttonAddElementAtEnd(){
    ArrayList.addAt(ArrayList.elements.length,generateArrayListElementRandDecNum())

    resetGetElementSpace()
}

function getElement(){
    let inputVal = document.getElementById("getAtThisIndex").value
    document.getElementById("getArrayListValue").innerHTML = "&nbsp;&nbsp;Returned Value: "+ ArrayList.elements[Number(inputVal)].value
}

function setElement(){
    let inputVal = document.getElementById("setAtThisIndex").value
    ArrayList.set(Number(inputVal), generateArrayListElementRandDecNum())

    resetGetElementSpace()
}

function removeElement(){
    let inputVal = document.getElementById("removeAtThisIndex").value
    ArrayList.remove(Number(inputVal))

    resetGetElementSpace()
}

function resetGetElementSpace(){
    document.getElementById("getArrayListValue").innerHTML = "&nbsp;&nbsp;Returned Value: "
}