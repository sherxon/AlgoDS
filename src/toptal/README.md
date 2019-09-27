White Box Testing to function solution

if (a == null || a.length == 0)

    (1.1)             (1.2)
return 0 (1.3)
    
if (a.length == 1)
        (2 )  
 
return 1 (3)
 
Set seta  (4)  

Set setb  (5) 

Set setc  (6) 

Set setd  (7)
     
for (8)

double d (9)

int x (10)

int  y (11)      
        
if (x > 0 && y > 0) (12)   

seta.add (12.1)

else if (x < 0 && y > 0)(13)

setb.add(13.1)

else if (x < 0 && y < 0) (14)

setc.add(14.1)

else (15)

setd.add(15.1)

return 16

=> Case Test

    T1:(1.1) (1.3)
    T2:(1.1) (1.2) (1.3)
    T3:(1) (2) (3)
    T4:(1) (2) (4) (5) (6) (7) (8) (9) (10) (11) (12) (12.1)
    (9) (10) (11) (12) (13) (13.1)
    (9) (10) (11) (12) (13) (14) (14.1)
    (9) (10) (11) (12) (13) (14) (15) (15.1) (16)
    T5:(1) (2) (4) (5) (6) (7) (8) (9) (10) (11) (12) (12.1)
           (9) (10) (11) (12) (12.1) 
           (9) (10) (11) (12) (12.1) (16)
    ..T6,T7,T8 similar T5        
           
        
        
