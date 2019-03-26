/* Script for calculator */

/*---------------- GLOBAL VARIABLES ----------------*/
var calculator, digit, digitsArea, numberPad, actionPad;
var d0, d1, d2, d3, d4, d5, d6, d7, d8, d9;
var plus, minus, divide, multiply, result, clear;
const MAX_DIGIT = 22; 
var operation = "";
var string = "";
var value = 0;


/*---------------- BUTTONS CREATE ----------------*/
function createFields() {
	/* === MAIN FIELD === */
	calculator = document.createElement("div");
	calculator.setAttribute("id","calculator");
	
	/* === DIGIT FIELD === */	
	digit = document.createElement("h3");
	digit.setAttribute("id","digits");
	digit.innerHTML = string;
	
	digitsArea = document.createElement("div");
	digitsArea.setAttribute("id","digitsArea");
	
	digitsArea.appendChild(digit);
	calculator.appendChild(digitsArea);
	
	/* === PAD === */
	var pad = document.createElement("div");
	pad.setAttribute("id","pad");
	
	/* === NUMBER PAD === */
	numberPad = document.createElement("div");
	numberPad.setAttribute("id","numberPad");
	pad.appendChild(numberPad);
	
	/* === ACTIONS PAD === */
	actionPad = document.createElement("div");
	actionPad.setAttribute("id","actionPad");
	pad.appendChild(actionPad);
	
	calculator.appendChild(pad);
}

function createDigitsButtons() {
	/* === DIGIT BUTTON 9 === */
	d9 = document.createElement("button");
	d9.innerHTML="9";
	d9.setAttribute("class","digitButton");
	d9.addEventListener("click", clickOnNine);
	numberPad.appendChild(d9);
	
	/* === DIGIT BUTTON 8 === */
	d8 = document.createElement("button");
	d8.innerHTML="8";
	d8.setAttribute("class","digitButton");
	d8.addEventListener("click", clickOnEight);
	numberPad.appendChild(d8);
	
	/* === DIGIT BUTTON 7 === */
	d7 = document.createElement("button");
	d7.innerHTML="7";
	d7.setAttribute("class","digitButton");
	d7.addEventListener("click", clickOnSeven);
	numberPad.appendChild(d7);
	
	/* === DIGIT BUTTON 6 === */
	d6 = document.createElement("button");
	d6.innerHTML="6";
	d6.setAttribute("class","digitButton");
	d6.addEventListener("click", clickOnSix);
	numberPad.appendChild(d6);
	
	/* === DIGIT BUTTON 5 === */
	d5 = document.createElement("button");
	d5.innerHTML="5";
	d5.setAttribute("class","digitButton");
	d5.addEventListener("click", clickOnFive);
	numberPad.appendChild(d5);
	
	/* === DIGIT BUTTON 4 === */
	d4 = document.createElement("button");
	d4.innerHTML="4";
	d4.setAttribute("class","digitButton");
	d4.addEventListener("click", clickOnFour);
	numberPad.appendChild(d4);
	
	/* === DIGIT BUTTON 3 === */
	d3 = document.createElement("button");
	d3.innerHTML="3";
	d3.setAttribute("class","digitButton");
	d3.addEventListener("click", clickOnThree);
	numberPad.appendChild(d3);
	
	/* === DIGIT BUTTON 2 === */
	d2 = document.createElement("button");
	d2.innerHTML="2";
	d2.setAttribute("class","digitButton");
	d2.addEventListener("click", clickOnTwo);
	numberPad.appendChild(d2);
	
	/* === DIGIT BUTTON 1 === */
	d1 = document.createElement("button");
	d1.innerHTML="1";
	d1.setAttribute("class","digitButton");
	d1.addEventListener("click", clickOnOne);
	numberPad.appendChild(d1);
	
	/* === DIGIT BUTTON 0 === */
	d0 = document.createElement("button");
	d0.innerHTML="0";
	d0.setAttribute("class","digitButton");
	d0.addEventListener("click", clickOnZero);
	numberPad.appendChild(d0);

}

function createActionButtons(){
	/* === PLUS CLEAR === */
	clear = document.createElement("button");
	clear.innerHTML="C";
	clear.setAttribute("class","actionButton");
	clear.addEventListener("click", clickOnClear);
	actionPad.appendChild(clear);
	
	/* === PLUS BUTTON === */
	plus = document.createElement("button");
	plus.innerHTML="+";
	plus.setAttribute("class","actionButton");
	plus.addEventListener("click", clickOnPlus);
	actionPad.appendChild(plus);
	
	/* === MINUS BUTTON === */
	minus = document.createElement("button");
	minus.innerHTML="-";
	minus.setAttribute("class","actionButton");
	minus.addEventListener("click", clickOnMinus);
	actionPad.appendChild(minus);
	
	/* === DIVIDE BUTTON === */
	divide = document.createElement("button");
	divide.innerHTML="/";
	divide.setAttribute("class","actionButton");
	divide.addEventListener("click", clickOnDivide);
	actionPad.appendChild(divide);
	
	/* === MULTIPLY BUTTON === */
	multiply = document.createElement("button");
	multiply.innerHTML="*";
	multiply.setAttribute("class","actionButton");
	multiply.addEventListener("click", clickOnMultiply);
	actionPad.appendChild(multiply);
	
	/* === RESULT BUTTON === */
	result = document.createElement("button");
	result.innerHTML="=";
	result.setAttribute("class","actionButton");
	result.addEventListener("click", clickOnResult);
	actionPad.appendChild(result);
}

/*---------------- BUTTONS FUNCTIONS ----------------*/
// DIGITS
function clickOnZero() {
	if(string !== "") {
		if(string.length<MAX_DIGIT){
			string = string + "0"
		}
	}
	digits.innerHTML = string;
}
function clickOnOne() {
	if(string.length<MAX_DIGIT){
		string = string + "1"
	}
	digits.innerHTML = string;
}
function clickOnTwo() {
	if(string.length<MAX_DIGIT){
		string = string + "2"
	}
	digits.innerHTML = string;
}
function clickOnThree() {
	if(string.length<MAX_DIGIT){
		string = string + "3"
	}
	digits.innerHTML = string;
}
function clickOnFour() {
	if(string.length<MAX_DIGIT){
		string = string + "4"
	}
	digits.innerHTML = string;
}
function clickOnFive() {
	if(string.length<MAX_DIGIT){
		string = string + "5"
	}
	digits.innerHTML = string;
}
function clickOnSix() {
	if(string.length<MAX_DIGIT){
		string = string + "6"
	}
	digits.innerHTML = string;
}
function clickOnSeven() {
	if(string.length<MAX_DIGIT){
		string = string + "7"
	}
	digits.innerHTML = string;
}
function clickOnEight () {
	if(string.length<MAX_DIGIT){
		string = string + "8"
	}
	digits.innerHTML = string;
}
function clickOnNine() {
	if(string.length<MAX_DIGIT){
		string = string + "9"
	}
	digits.innerHTML = string;
}

// ACTIONS
function clickOnPlus() {
	if(value == ""){
		value = Number(string);
	}
	string = "";
	operation = "plus";
	digits.innerHTML = string;
}

function clickOnMinus() {
	if(value == ""){
		value = Number(string);
	}
	string = "";
	operation = "minus";
	digits.innerHTML = string;
}

function clickOnDivide() {
	if(value == ""){
		value = Number(string);
	}
	string = "";
	operation = "divide";
	digits.innerHTML = string;
}

function clickOnMultiply() {
	if(value == ""){
		value = Number(string);
	}
	string = "";
	operation = "multiply";
	digits.innerHTML = string;
}

function clickOnClear() {
	string = "";
	value = "";
	digits.innerHTML = string;
}

function clickOnResult() {
	if(value !="" && string !=""){
		if(operation == "plus"){
			value = value + Number(string);
			digits.innerHTML = value;
			operation = "";
			string = "";
			return;
		}
		if(operation == "minus"){
			value = value - Number(string);
			digits.innerHTML = value;
			operation = "";
			string = "";
			return;
		}
		if(operation == "divide"){
			value = value / Number(string);
			digits.innerHTML = value;
			operation = "";
			string = "";
			return;
		}
		if(operation == "multiply"){
			value = value * Number(string);
			digits.innerHTML = value;
			operation = "";
			string = "";
			return;
		}		
	}else{
		digits.innerHTML = "Вы не ввели значение для счёта";
	}
}

/*---------------- MAIN ----------------*/
function calculator() {
	createFields();
	createDigitsButtons();
	createActionButtons();
	document.body.appendChild(calculator);
	
}
