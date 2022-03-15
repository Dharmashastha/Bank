function trapSequence(a,b,end)
{
	var n=a;
	const map=new Map();
	for(a;a <= end;a++)
		{
			var c= getsum(a);	
			if(a == b || a%b == 0 || b%a == 0 || c%b == 0 || b%c == 0)
				{
					//console.log(a+" "+b);
					map.set(a,b);
					b += 2;			
				}
			else
				{
					if(b <= n)
						{
						}
					else
						{
							b -= 1;
							//console.log("b is "+b);
						}	
				}
			
		}
return map;				
}

function getsum(number)
{
	var sum = 0;
     	while (number >= 1) 
		{
             sum = sum + number % 10;
             number = Math.floor(number / 10);
			 //console.log("sum is"+sum);
        }
        return sum;	
}