var ourWindow = window;
var ourLocation = location;
var ourNavigator = navigator;
var ourHistory = history;
var ourScreen = screen;
var ourDoc = document;

ourDoc.addEventListener('DOMContentLoaded', domExperiment);
console.log("корневой скрипт");

/*var f666 = new Function('f666', "{
		console.log("function666");
	}");*/

function domExperiment(){
	console.log("эксперементальная функция стартовала");
	console.log(ourWindow);
	console.log(ourLocation);
	console.log(ourNavigator);
	console.log(ourHistory);
	console.log(ourScreen);
	console.log(document);
	console.log("--------------");
	console.log('width='+ourScreen.screenX);
	console.log('width='+window.screen.width);
	
	var btn = ourDoc.createElement("BUTTON");
	btn.innerHTML="<b>Кнопка1</b>";
	document.body.appendChild(btn);  
	var div = ourDoc.createElement("div");
	div.innerHTML="содержимое дива";
	div.setAttribute("style", "background-color: green")
	var fignya = ourDoc.createElement("infoFromVerstalshchik");
	document.body.appendChild(fignya);  
	document.body.appendChild(div);
	
	btn.addEventListener("click", function (){
		console.log("clicked");
		
	})
}


