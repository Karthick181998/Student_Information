function validatePhoneNumber(){
			var phoneNumer=document.getElementById('phno').value;
			var msg=document.getElementById('message');		
			if(phoneNumer.length !==10){
				msg.textContent="*Phone number must be 10 digit...";
				return false;
			}	
		}
		
		 window.addEventListener('load', function() {
            const studentButton = document.getElementById('student-login');
            const adminButton = document.getElementById('admin-login');
            setTimeout(function() {
                studentButton.style.opacity = '1';
                adminButton.style.opacity = '1';
            }, 1000); 
        });
        
        document.getElementById("dateInput").addEventListener("change",function(){
			const selectedDate=this.value;
			const parts=selectedDate.split("-");
			const formattedDate=parts[2]+"-"+parts[0]+"-"+parts[1];
			this.value=formattedDate;
		});