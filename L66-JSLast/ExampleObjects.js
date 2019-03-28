"use strict"
"Привет, мир!".length;  //тип String
"Привет, мир!".toUpperCase(); //и прочие типичные для стринга методы 
[1, 2].forEach(console.log); //и прочие типичные для списка\очереди\стэка методы. Например pop push shift unshift sort...
console.log( 12.355.toFixed(1) ); // 12.3 тип Number
console.log( 12..toFixed(1) ); // 12.0 тип Number

var myObject = {};
var myObject2 = new Object();


myObject.newProperty="something";
myObject.newProperty="updatedValue";
myObject["newProperty"] = "thirdUpdate"; 
//like Java's myObject.put("newProperty", "forthUpdate");
//delete myObject.newProperty;


for (var i = 0; i<10; i++){
	//myObject.pole ??? i = i;
	myObject["pole" + i] = i
}



myObject.firstMethod = function(){
	var a=0;
	var b=5;
	console.log("this=" + this);
	console.log(b/a + this.newProperty);
	
	var f2 = function(){
		console.log("this of f2=" + this);
	}
	f2();
}

myObject.firstMethod();
myObject2.firstMethod = myObject.firstMethod;
myObject2.firstMethod();
//let firstMethod = myObject.firstMethod;
//firstMethod();
console.log('--------------------');
var massiv = [1,2];
for (var svoystvo in myObject2) {
	console.log(svoystvo + 
			"=" + myObject[svoystvo]);
}
console.log('--------------------');
myObject.svoystvo = undefined;
if ("svoystvo" in myObject) {
	console.log(svoystvo + 
			"=" + myObject[svoystvo]);
} else {
	console.log("Niama svoystva")
}

if (myObject.svoystvo !== undefined) {
	console.log(svoystvo + 
			"=" + myObject[svoystvo]);
} else {
	console.log("Niama  svoystva")
}

console.log(myObject.asdfgh);//ok, undefined
//console.log(myObject.asdfgh.dgh);//not ok, NPE


myObject.svoystvo = "new Value";
myObject[svoystvo] = "new Value again"; 



var user1 ={
	name: "Vasya",
	sex: "malchik",
	action: function(){console.log("smotryu futbol")}
};
var user2 ={
		name: "Vasya",
		sex: "malchik",
		action: function(){console.log("smotryu futbol")},
		//equals: function(otherUser){/*...*/}
};
var user3 ={
		name: "Elleonora",
		"sex": "lady",
		action: function(){console.log("smotryu dom2 i odevayus")}
};
//user2 = user1;
//user2.name = "Elleonor";
//console.log(user2.name);
//console.log(user1.name); as in java
console.log(user1 == user2);
console.log(user1 === user2);

var arr = [];
//arr[1000] = 'znachenie';
arr[1000] = undefined; //(1001 anyway)
console.log(arr.length); // 1001 

var arr2 = {length:0}
arr2[100] = "newVal";
alert(arr2.length)













