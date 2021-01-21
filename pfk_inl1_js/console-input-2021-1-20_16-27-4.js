// för att köra, firefox webläsare, shift+F5 för console, ctrl+B för multiline, ctrl+O för att läsa in fil
// https://developer.mozilla.org/en-US/docs/Tools/Web_Console/The_command_line_interpreter#multi-line_mode

document.body.innerHTML = '';	//clear page
var colorOption=0; // variabel för att styra vilken färg som är nästa på text
loopit:{ // label för exit för liknande beteende som i c# och java avslut av console, men webläsare, börjar om
	while(true){
  
    //print menu
		document.write("Menu \n<br>");
		document.write(" 0  exit \n<br>");
		document.write(" 1  echo hello world \n<br>");
		document.write(" 2  read name surname age  then echo name surname age \n<br>");
		document.write(" 3  change color of text \n<br>");
    document.write(" 4  write todays date \n<br>");
    document.write(" 5  read two input, echo largest \n<br>");
    document.write(" 6  guessing game \n<br>");
    document.write(" 7   		write input to file, not possible currently \n<br>");
    document.write(" 8   		read input from file, not possible currently  \n<br>");
    document.write(" 9   input decimal number echo sqrt pow2 pow10 \n<br>");
    document.write(" 10  write multiplication table \n<br>");
    document.write(" 11   randomize an array, sort it , print both version \n<br>");
    document.write(" 12   \n<br>");
    document.write(" 13   \n<br>");
    document.write(" 14   \n<br>");
    document.write(" 15   \n<br>");
    document.write(" 16   \n<br>");
		document.write("<br>");
  
		var order = prompt('type option','-1'); // input
  
    //actions
  	if(order==0){    
  		break loopit; // har valt att inte göra funktionsanrop, vilket gör att saker behålls i minnet. bad or feature?
  	}
  	else if(order==1){
    	document.write("Hello world<br><br>"); 
  	}
  	else if(order==2){
			let name = prompt('please your name ','name');
   		let surname = prompt('please your surname','surname');
    	let age = prompt('please your age','age');
    	document.write("you are "+name+" "+surname+" and your age is "+age+"<br><br>");
  	} 
    else if (order==3) {
      if(colorOption==0){
      	let html = document.body.style.color='blue';
        colorOption=1;
      }else if(colorOption==1){
      	let html = document.body.style.color='red';
        colorOption=2;
      }else if(colorOption==2){
      	let html = document.body.style.color='yellow';
        colorOption=3;
      }else if(colorOption==3){
      	let html = document.body.style.color='green';
        colorOption=4;
      }else{
        let html = document.body.style.color='black';
        colorOption=0;
      }
    }
    else if (order==4) {
             // skriv dagens datum
      
      //https://stackoverflow.com/questions/23593052/format-javascript-date-as-yyyy-mm-dd
      var date = new Date().toLocaleDateString('se-SE', {year: 'numeric', month: '2-digit', day: '2-digit'});
      document.write(date+"<br><br>");
      
    }
    else if (order==5) {
             // read two input echo largest
      
      let	num0 = Number(prompt('please input a number ','0')) ;  
      
      let num1 = Number(prompt('please input a number ','1'));
      
      if( (num0==NaN) ||(num1==NaN) ){
         document.write(" one of the inputs was not a number<br><br>");
      }
      else if(num0>num1){
         document.write("the largest number is: "+num0 +"<br><br>");     
      }
      else {//if(num0>num1){
         document.write("the largest number is: "+num1 +"<br><br>");     
      }
      
      
     }
    else if (order==6) {
      let secret = Math.ceil(Math.random()*100);
     		document.write(" Guess a number between 1 and 100 <br><br>");
        let temp=false;
      	let counter=0;
        while(!temp){
            let num1 = Number(prompt('please input a number ','1'));
          counter++;
          if(num1==secret){
             temp=true;
          } 
          else if(num1<secret){
            document.write("guess higher <br><br>");
          }else{
            document.write("guess lower <br><br>");
          }
        }
      
      	document.write("Right spot on!, number of attempts: "+counter+"<br><br>");
    		temp=false; 		
    }
    else if (order==7) {
      // my conclusion is that it is possible to mimic file behavior by using cookies local storage etc but cant write directly to file from brwser
      // https://stackoverflow.com/questions/21012580/is-it-possible-to-write-data-to-file-using-only-javascript       
     }
    else if (order==8) {
      // my conclusion is that it is possible to mimic file behavior by using cookies local storage etc but cant write directly to file from brwser
       // https://stackoverflow.com/questions/21012580/is-it-possible-to-write-data-to-file-using-only-javascript      
     }
    else if (order==9) {
    	let num1 = parseFloat(prompt('please input a number ','1'));
      document.write(" num: "+num1+" sqrt: "+Math.sqrt(num1)+" pow2 " +Math.pow(num1, 2) +" pow10 " + Math.pow(num1, 10) +"<br><br>");
     }
    else if (order==10) {
             //skriv ut multiplikationstabell
      for(let i=0; i<10;i++){
        var str="";
       	for(let j=0; j<10;j++){
        	str= str+"\t"+(i*j);
      	} 
        document.write(str+"<br><br>");
      }
      
     }
    else if (order==11) {
         var [] arr = { Math.random(1,100) ,Math.random(1,100) ,Math.random(1,100) ,Math.random(1,100) };
    
     }
    else if (order==12) {
             
     }
    else if (order==13) {
             
     }
    else if (order==14) {
             
     }
    else if (order==15) {
             
     }
    else if (order==16) {
             
     }
	}//while
}//loopit label
document.write("Det blev exit, men sidan körs ju hela tiden lixom, du får ladda om sidan<br><br>"); 