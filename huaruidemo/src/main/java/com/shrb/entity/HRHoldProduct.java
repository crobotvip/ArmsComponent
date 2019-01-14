package com.shrb.entity;

import java.io.Serializable;

/**
 * Created by user on 2016/11/24.
 */

public class HRHoldProduct implements Serializable {

    private int comfirmVol;
    private int confirmBalance;
    private int dividendType;
    private int eStimateTotalIncom;
    private InvestCardListBean investCardList;
    private int productCode;
    private int productId;
    private int productName;
    private int productType;
    private int redemptionVol;
    private int status;
    private int submitBalance;
    private int totalIncome;
    private int yesterdayIncome;

    public int getComfirmVol() {
        return comfirmVol;
    }

    public void setComfirmVol(int comfirmVol) {
        this.comfirmVol = comfirmVol;
    }

    public int getConfirmBalance() {
        return confirmBalance;
    }

    public void setConfirmBalance(int confirmBalance) {
        this.confirmBalance = confirmBalance;
    }

    public int getDividendType() {
        return dividendType;
    }

    public void setDividendType(int dividendType) {
        this.dividendType = dividendType;
    }

    public int getEStimateTotalIncom() {
        return eStimateTotalIncom;
    }

    public void setEStimateTotalIncom(int eStimateTotalIncom) {
        this.eStimateTotalIncom = eStimateTotalIncom;
    }

    public InvestCardListBean getInvestCardList() {
        return investCardList;
    }

    public void setInvestCardList(InvestCardListBean investCardList) {
        this.investCardList = investCardList;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductName() {
        return productName;
    }

    public void setProductName(int productName) {
        this.productName = productName;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getRedemptionVol() {
        return redemptionVol;
    }

    public void setRedemptionVol(int redemptionVol) {
        this.redemptionVol = redemptionVol;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSubmitBalance() {
        return submitBalance;
    }

    public void setSubmitBalance(int submitBalance) {
        this.submitBalance = submitBalance;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getYesterdayIncome() {
        return yesterdayIncome;
    }

    public void setYesterdayIncome(int yesterdayIncome) {
        this.yesterdayIncome = yesterdayIncome;
    }

    public static class InvestCardListBean {

        private int accType;
        private int payAcctNo;
        private int payBankName;
        private int transAmt;

        public int getAccType() {
            return accType;
        }

        public void setAccType(int accType) {
            this.accType = accType;
        }

        public int getPayAcctNo() {
            return payAcctNo;
        }

        public void setPayAcctNo(int payAcctNo) {
            this.payAcctNo = payAcctNo;
        }

        public int getPayBankName() {
            return payBankName;
        }

        public void setPayBankName(int payBankName) {
            this.payBankName = payBankName;
        }

        public int getTransAmt() {
            return transAmt;
        }

        public void setTransAmt(int transAmt) {
            this.transAmt = transAmt;
        }
    }
}
