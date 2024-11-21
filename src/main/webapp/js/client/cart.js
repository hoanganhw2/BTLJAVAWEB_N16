const standardDeliveryPrice = 25000; // Giá giao tiêu chuẩn
const expressDeliveryPrice = 50000;   // Giá giao nhanh

const tempPriceElement = document.getElementById('temp-price');
const deliveryPriceElement = document.getElementById('delivery-price');
const totalPriceElement = document.getElementById('total-price');

// Giả sử giá tạm tính là 100000 đồng
let tempPrice = 100000;

// Cập nhật giá trị ban đầu
tempPriceElement.textContent = tempPrice;

document.querySelectorAll('input[name="delivery-method"]').forEach((input) => {
    input.addEventListener('change', function () {
        let deliveryPrice = 0;

        // Kiểm tra hình thức giao hàng đã chọn
        if (this.id === 'delivery-method-1') {
            deliveryPrice = standardDeliveryPrice;
        } else if (this.id === 'delivery-method-2') {
            deliveryPrice = expressDeliveryPrice;
        }

        // Cập nhật giá trị hiển thị
        deliveryPriceElement.textContent = deliveryPrice;
        totalPriceElement.textContent = tempPrice + deliveryPrice;
    });
});