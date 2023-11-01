function validatePhoneNumber(){
			var phoneNumer=document.getElementById('phno').value;
			var msg=document.getElementById('message');		
			if(phoneNumer.length !==10){
				msg.textContent="*Phone number must be 10 digit...";
				return false;
			}	
		}
		
		 window.addEventListener('load', function() {
			
            const studentAdd = document.getElementById('student-add');
            const studentView = document.getElementById('student-view');
            const studentUpdate = document.getElementById('student-update');
            const studentRemove = document.getElementById('student-remove');
            const studentLogin = document.getElementById('student-login');
            const adminLogin = document.getElementById('admin-login');
            setTimeout(function() {
				
                studentAdd.style.opacity = '1';
                studentView.style.opacity = '1';
                studentUpdate.style.opacity = '1';
                studentRemove.style.opacity = '1';
                studentLogin.style.opacity = '1';
                adminLogin.style.opacity = '1';
            }, 1000); 
        });
         window.addEventListener('load', function() {
            const studentLogin = document.getElementById('student-login');
            const adminLogin = document.getElementById('admin-login');
            setTimeout(function() {
                studentLogin.style.opacity = '1';
                adminLogin.style.opacity = '1';
            }, 1000); 
        });
        
        document.getElementById("dateInput").addEventListener("change",function(){
			const selectedDate=this.value;
			const parts=selectedDate.split("-");
			const formattedDate=parts[2]+"-"+parts[0]+"-"+parts[1];
			this.value=formattedDate;
		});