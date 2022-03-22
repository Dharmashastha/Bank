function breakpoint() 
{
	const br = document.createElement("br");
	document.body.appendChild(br);
}

function addStatus()
{
	const radioText=document.createElement("input");
	radioText.setAttribute("type","radio");
	radioText.setAttribute("value","text");
	radioText.setAttribute("name","status");
	radioText.textContent="Text";
	document.body.appendChild(radioText);
	
	breakpoint();
	
	const radioImg=document.createElement("input");
	radioImg.setAttribute("type","radio");
	radioImg.setAttribute("value","Image");
	radioImg.setAttribute("name","status");
	radioImg.textContent="Image";
	document.body.appendChild(radioImg);
	
	breakpoint();
	
	

}

