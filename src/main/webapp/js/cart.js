const DELIVERY_PRICES = {
    standard: 25000,
    express: 50000
};
// Xử lý khi thay đổi phương thức giao hàng
document.querySelectorAll('input[name="delivery-method"]').forEach((input) => {
    input.addEventListener('change', function() {
        // Lấy giá trị tạm tính và chuyển thành số
        const tempPrice = parseInt(document.getElementById('temp-price').textContent.replace(/[^\d]/g, ''));
        
        // Tính phí giao hàng
        const deliveryPrice = this.id === 'delivery-method-1' ? DELIVERY_PRICES.standard : DELIVERY_PRICES.express;
        
        // Cập nhật hiển thị
        document.getElementById('delivery-price').textContent = 
            new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(deliveryPrice);
            
        document.getElementById('total-price').textContent = 
            new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(tempPrice + deliveryPrice);
    });
});