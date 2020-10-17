/**
 * 注册模块中的javascript代码
 */
function way1(){
  	var uname=document.rgform.username.value;
  	if(uname==""){
  		//alert("用户名不能为空！");
  		document.getElementById("print1").innerHTML = "<font color='red'>×用户名不能为空</font>";
  		return false;
  	}
  	else
  	{
  		document.getElementById("print1").innerHTML = "<font color='green'>√</font>";
  		return true;
  	}
}
function way2(){
  	var pword=document.rgform.password.value;
  	if(pword==""){
  		//alert("密码不能为空！");
  		document.getElementById("print2").innerHTML = "<font color='red'>×密码不能为空</font>";
  		return false;
  	}
  	else if(pword.length<6){
  		//alert("必须在6位以上");
  		document.getElementById("print2").innerHTML = "<font color='red'>×必须在6位以上</font>";
  		return false;
  	}
  	else if(pword.length>5&&pword.length<9){
  		document.getElementById("print2").innerHTML = "<font color='green'>密码强度：弱</font>";
  		return true;
  	}
  	else if(pword.length>8&&pword.length<12){
  		document.getElementById("print2").innerHTML = "<font color='green'>密码强度：中</font>";
  		return true;
  	}
  	else if(pword.length>11&&pword.length<17){
  		document.getElementById("print2").innerHTML = "<font color='green'>密码强度：强</font>";
  		return true;
  	}
  	else
  	{	
  		document.getElementById("print2").innerHTML = "<font color='green'>密码强度：超强</font>";
  		return true;
  	}
}
function way3(){
  	var pword1=document.rgform.password1.value;
  	var pword=document.rgform.password.value;
  	if(pword1==""){
  		//alert("密码不能为空！");
  		document.getElementById("print3").innerHTML = "<font color='red'>X密码不能为空</font>";
  		return false;
  	}
  	else if(pword!=pword1){
  		//alert("密码须一致！");
  		document.getElementById("print3").innerHTML = "<font color='red'>X密码须一致</font>";
  		return false;
  	}
  	else
  	{	
  		document.getElementById("print3").innerHTML = "<font color='green'>√密码一致</font>";
  		return true;
  	}
}
function way4(){
	var patten=/^((19[2-9]\d{1})|(20((0[0-9])|(1[0-8]))))\-((0?[1-9])|(1[0-2]))\-((0?[1-9])|([1-2][0-9])|30|31)$/;
	var birthday=document.rgform.birth.value;
	if(birthday==""){
		document.getElementById("print4").innerHTML = "";
		return true;
	}
	else if(patten.test(birthday)==false){
		document.getElementById("print4").innerHTML = "<font color='red'>X格式不正确</font>";
		return false;
	}
	else{
		document.getElementById("print4").innerHTML = "<font color='green'>√</font>";
		return true;
	}
}
function way5(){
  	var phone=document.rgform.phone.value;
  	var patten=/^[0-9]*$/;
  	if(phone==""){
  		document.getElementById("print5").innerHTML = "<font color='red'>X电话号码不能为空！</font>";
  		return false;
  	}
  	else if(patten.test(phone)==false){
  		document.getElementById("print5").innerHTML = "<font color='red'>X必须为数字</font>";
  		return false;
  	}
  	else if(phone.length<7){
  		document.getElementById("print5").innerHTML = "<font color='red'>X不能少与7位</font>";
  		return false;
  	}
  	else{
  		document.getElementById("print5").innerHTML = "<font color='green'>√</font>";
  		return true;
  	}
}
function way6(){
  	var idnumber=document.rgform.idnum.value;
  	var patten=/^[0-9]*$/;
  	if(idnumber==""){
  		document.getElementById("print6").innerHTML = "<font color='red'>X身份证号不能为空！</font>";
  		return false;
  	}
  	else if(idnumber.length!=18){
  		document.getElementById("print6").innerHTML = "<font color='red'>X必须为18位</font>";
  		return false;
  	}
  	else if(patten.test(idnumber)==false){
  		document.getElementById("print6").innerHTML = "<font color='red'>X必须为数字</font>";
  		return false;
  	}
  	else{
  		document.getElementById("print6").innerHTML = "<font color='green'>√</font>";
  		return true;
  	}
}
function sbm(){
	var sex=document.rgform.sex.value;
	if(sex==""){
		alert("性别不能为空！");
		return false;
	}
  	rgform.submit();
}