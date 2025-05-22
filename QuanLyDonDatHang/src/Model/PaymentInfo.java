package Model;

import java.util.Date;

public class PaymentInfo {
    private double amount;
    private String status;
    private Date paymentDate;
    
    public PaymentInfo(double amount, String status, Date paymentDate) {
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Số tiền: " + amount + ", Trạng thái: " + status + 
               ", Ngày đóng: " + (paymentDate != null ? paymentDate.toString() : "Chưa đóng");
    }
}
