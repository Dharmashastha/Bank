function trapSequence(start,b,end)
{
	var n1 = 0;
	const map=new Map();
	for(n1=start;n1 <= end;n1++)
		{
			let a= n1;
			while(true)
			{	
			//console.log(c);	
			if(a%b == 0 || b%a == 0)
				{
					//console.log(a+" "+b);
					map.set(n1,b);
					b=b+2;
					break;			
				}
			else
				{
					
					if(a < 10)
					{
						if(3 < b)
							{
								b--;
							}
							break;
					}
						var  c= getsum(a);
						a=c;	
				}
			}
		}
return map;		
}				


function getsum(number)
{
	var sum = 0;
     	while (number > 0) 
		{
             sum = sum + number % 10;
             number = Math.floor(number / 10);
			 //console.log("sum is"+sum);
        }	
return sum;

		/*if(number % 9 == 0)
		{
			return 9;
		}
		else
		{
			return number % 9;
		}*/
}