// check dieu kien form dang ky

document.getElementById("FormResgister").addEventListener('submit', function(event){
	
const checkbox = document.getElementById('checkboxPolicy');
            const errorMessage = document.getElementById('errorMessage');

            if (!checkbox.checked) {
                event.preventDefault(); // Ngăn không cho gửi form
                errorMessage.style.display = 'block'; // Hiện thông báo lỗi
            } else {
                errorMessage.style.display = 'none'; // Ẩn thông báo lỗi nếu checkbox đã được chọn
            }
  });


