// för att köra, firefox webläsare, shift+F5 för console, ctrl+B för multiline, ctrl+O för att läsa in fil
// https://developer.mozilla.org/en-US/docs/Tools/Web_Console/The_command_line_interpreter#multi-line_mode

class Character{
  
  
  constructor(name){
    this.name=name;
    this.health=Number(Math.random(1,100));
    this.luck=Number(Math.random(1,100));
    this.strength=Number(Math.random(1,100));
  }
  get name(){return this._name;}
  get strength(){return this._strength;}
  get luck(){return this._luck;}
  get health(){return this._health;}
  get toString(){return "name: "+this.name+" strength: "+this.strength+" luck: "+this.luck+" health: "+this.health ;}
  
  set name(value){this._name=value;}
  set health(value){this._health=value;}
  set luck(value){this._luck=value;}
  set strength(value){this._strength=value;}
  
}

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
    document.write(" 12   read input, check if palindrom \n<br>");
    document.write(" 13   read two inputs, print numbers between inputs \n<br>");
    document.write(" 14   input numbers separated with comma, sort in odd and even then output\n<br>");
    document.write(" 15   input numbers separated with comma, sum them up then output \n<br>");
    document.write(" 16   type name of you and your opponent, get random values as luck,strength and health\n<br>");
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
        let  arr = [Math.random(1,100) ,Math.random(1,100) ,Math.random(1,100) ,Math.random(1,100) ];
    		let str ="";
    		for(let i=0;i<4;i++){
          str+=arr[i]+ " ";
        }
    	document.write(str+"<br><br>");
    	//document.write("will sort alphabeticly, not numericly<br><br>"); // was wrong, or just by chanse
    	str="";
    	arr.sort();
    	for(let i=0;i<4;i++){
          str+=arr[i]+ " ";
        }
    	document.write(str+"<br><br>");
    }
    else if (order==12) {
       // read test palindrom
      let str = prompt('please input a palindrom suggestion ','');
      
      
      // stole this from https://www.freecodecamp.org/news/two-ways-to-check-for-palindromes-in-javascript-64fea8191fd7/
      // to show my insanely good googling skillz, oh, rewrote it some to consider Im not doing a function.
      
      var re = /[^A-Za-z0-9]/g;
 			str = str.toLowerCase().replace(re, '');
 			var len = str.length;
      let test=true;
 			for (var i = 0; i < len/2; i++) {
   			if (str[i] !== str[len - 1 - i]) {
       		test= false;
   			}
 			}
 			
      // my code below
      
      document.write("palindrome status: "+test+"<br><br>");
      
     }
    else if (order==13) {
      // read two inputs print numbers inbetween
    	let num0 = Number(prompt('please input a number ',''));
      let num1 = Number(prompt('please input a number ',''));
      
      if(num0>num1){
        let num3=num0;
        num0=num1;
        num1=num3;
      }
      let str="";
      for(let i=num0; i<=num1;i++){
        str+=" "+i;
      }
      document.write("start inbetween.. stop :"+str+"<br><br>");
    }
    else if (order==14) {
      let str = prompt('please input numbers ','');    
      let arr = str.split(',');
    	let even= "even: "  ;
      let odd ="odd: ";
      for( let i =0; i<arr.length;i++ ){
        let num= Number(arr[i]);
        if(num%2==1){
          odd+=" "+num;
        }else{
          even+=" "+num;
        }        
      }
      document.write(even+"<br><br>");
      document.write(odd+"<br><br>");
    }
    else if (order==15) {
      let str = prompt('please input numbers ','');    
     	let arr = str.split(',');  
      let sum=0.0;
      for( let i =0; i<arr.length;i++ ){
    		 sum+= Number(arr[i]);
      }
       document.write("sum: "+sum+"<br><br>");
    }
    else if (order==16) {
        let str = prompt('please input name ','');
      	let char = new Character(str);
      str = prompt('please input opponent name ','');
      	let opponent = new Character( str );
      	document.write( "player: " + char.toString+"<br><br>");
      	document.write( "opponent: " + opponent.toString+"<br><br>");
     }
	}//while
}//loopit label
document.write("Det blev exit, men sidan körs ju hela tiden lixom, du får ladda om sidan<br><br>"); 

// classen högst upp i filen kommer läsas in igen och du får fel i utskriften, har inte kollat på detta men tänker att den skall vara i egen fil som man importerar , fast kanske få samma fel, elelr tja, är väl inte tänkt att man skall ha en loop såhär kanske i js, finns säkert något bättre sätt