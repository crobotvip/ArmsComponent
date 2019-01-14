package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shrb.hrsdk.sdk.HRSDK;

import java.util.ArrayList;

/**
 * Created by user on 2016/11/30.
 */

public class FunctionSelectActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private ListView lv_function;
    ArrayList<Function> functions = new ArrayList<>();
    FunctionAdapter adapter;
    private final int BACK = 0;//返回上级菜单
    private final int USER = 1;//用户
    private final int ORDER = 2;//支付
    private final int FINANCING = 3;//融资
    private final int BIND_CARD = 11;//绑卡
    private final int GET_OPENID = 12;//获取openID
    private final int RECHARGE = 13;//充值
    private final int WITHDRAW = 14;//提现
    private final int AUTHENTICATE = 15;//验证二类户
    private final int JF = 21;//极付
    private final int JSH = 22;//极时花
    private final int JSH_QUERY = 23;//极时花查询
    private final int SCAN_CODE_PAY = 24;//扫码支付
    private final int CREATE_CODE_PAY = 25;//生成支付码支付
    private final int LOAN = 31;//贷款
    private final int LOAN_REQUEST = 32;//额度申请
    private final int CHECK_LOAN = 33;//是否授信
    private final int RATE = 34;//存贷款利率
    private final int NEWS_LIST = 35;//新闻列表


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_select);
        findViewById(R.id.tv_back).setOnClickListener(this);
        lv_function = (ListView) findViewById(R.id.lv_function);
        adapter = new FunctionAdapter();
        lv_function.setAdapter(adapter);
        lv_function.setOnItemClickListener(this);
        initFunction();
    }

    private void initFunction() {
        functions.clear();
        functions.add(new Function(USER, "用户"));
        functions.add(new Function(ORDER, "支付"));
        functions.add(new Function(FINANCING, "极度贷"));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (functions.get(0).functionType != 1) {
            initFunction();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (adapter.getItem(position).functionType) {
            case BACK:
                initFunction();
                break;
            case USER:
                functions.clear();
                functions.add(new Function(BIND_CARD, "绑卡"));
                functions.add(new Function(GET_OPENID, "获取openID"));
                functions.add(new Function(RECHARGE, "充值"));
                functions.add(new Function(WITHDRAW, "提现"));
                functions.add(new Function(AUTHENTICATE, "二类户显示"));
                functions.add(new Function(BACK, "返回上级菜单"));
                adapter.notifyDataSetChanged();
                break;
            case ORDER:
                functions.clear();
                functions.add(new Function(JF, "极付"));
                functions.add(new Function(JSH, "极时花"));
                functions.add(new Function(JSH_QUERY, "极时花查询"));
                functions.add(new Function(SCAN_CODE_PAY, "扫码支付"));
                functions.add(new Function(CREATE_CODE_PAY, "生成支付码支付"));
                functions.add(new Function(BACK, "返回上级菜单"));
                adapter.notifyDataSetChanged();
                break;
            case FINANCING:
                functions.clear();
                functions.add(new Function(LOAN, "极度贷"));
                functions.add(new Function(LOAN_REQUEST, "额度申请"));
                functions.add(new Function(CHECK_LOAN, "是否授信"));
                functions.add(new Function(RATE, "存贷款利率"));
                functions.add(new Function(NEWS_LIST, "新闻列表"));
                functions.add(new Function(BACK, "返回上级菜单"));
                adapter.notifyDataSetChanged();
                break;
            case SCAN_CODE_PAY:
                Intent scanCodePay = new Intent(this, ScanCodeActivity.class);
                startActivity(scanCodePay);
                break;
            case CREATE_CODE_PAY:
                Intent createCodePay = new Intent(this, CreateCodeActivity.class);
                startActivity(createCodePay);
                break;
            case AUTHENTICATE:
                Intent authenticate = new Intent(this, AuthenticateActivity.class);
                startActivity(authenticate);
                break;
            case BIND_CARD:
                Intent bindCard = new Intent(this, BindCardActivity.class);
                startActivity(bindCard);
                break;
            case RECHARGE:
                Intent recharge = new Intent(this, RechargeActivity.class);
                startActivity(recharge);
                break;
            case WITHDRAW:
                Intent withdraw = new Intent(this, WithdrawActivity.class);
                startActivity(withdraw);
                break;
            case GET_OPENID:
                Intent getOpenID = new Intent(this, GetOpenIDActivity.class);
                startActivity(getOpenID);
                break;
            case JF:
                Intent jf = new Intent(this, OrderPayActivity.class);
                jf.putExtra("payType", HRSDK.PAY_JF);
                startActivity(jf);
                break;
            case JSH:
                Intent jsh = new Intent(this, OrderPayActivity.class);
                jsh.putExtra("payType", HRSDK.PAY_JSH);
                startActivity(jsh);
                break;
            case JSH_QUERY:
                Intent jsh_query = new Intent(this, SpeedPayQueryActivity.class);
                startActivity(jsh_query);
                break;
            case LOAN:
                Intent loan = new Intent(this, LoanActivity.class);
                startActivity(loan);
                break;
            case CHECK_LOAN:
                Intent checkLoan = new Intent(this, CheckLoanActivity.class);
                startActivity(checkLoan);
                break;
            case LOAN_REQUEST:
                Intent loanRequest = new Intent(this, LoanRequestActivity.class);
                startActivity(loanRequest);
                break;
            case RATE:
                Intent rate = new Intent(this, RateActivity.class);
                startActivity(rate);
                break;
            case NEWS_LIST:
                Intent newsList = new Intent(this, NewsListActivity.class);
                startActivity(newsList);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                onBackPressed();
                break;
        }
    }

    class Function {
        public int functionType;
        public String functionName;

        public Function(int functionType, String functionName) {
            this.functionType = functionType;
            this.functionName = functionName;
        }
    }

    class FunctionAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return functions.size();
        }

        @Override
        public Function getItem(int position) {
            return functions.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(FunctionSelectActivity.this).inflate(R.layout.item_function, parent, false);
            TextView tv_function = (TextView) view.findViewById(R.id.tv_function);
            tv_function.setText(getItem(position).functionName);
            return view;
        }
    }
}
