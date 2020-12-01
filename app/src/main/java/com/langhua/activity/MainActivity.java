package com.langhua.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.langhua.fragment.DetailFragment;
import com.langhua.fragment.MineFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTabDetail, mTabMine;
    Button account_bt;
    private Fragment DetailFragment, NoMineFragment, MineFragment;
    private int mFragmentId = 0;

    // 标记三个Fragment
    public static final int FRAGMENT_DETAIL = 0;
    public static final int FRAGMENT_NOMINE = 1;
    public static final int FRAGMENT_MINE = 2;


    // 标记MineFragment的状态
    public static final int MINE = 0; // 记录未登录的时候状态
    public static final int NOMINE = 1; // 记录登录以后的状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, AccountActivity.class);

        account_bt = findViewById(R.id.tv_account);

        mTabDetail = findViewById(R.id.tv_detail);
        mTabMine = findViewById(R.id.tv_mine);

        // 根据传入的Bundle对象判断Activity是正常启动还是销毁重建
        if (savedInstanceState == null) {
            // 设置第一个Fragment默认选中
            setFragment(mFragmentId);
        }

        mTabDetail.setOnClickListener(this);
        mTabMine.setOnClickListener(this);

        account_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        // 通过FragmentManager获取保存在FragmentTransaction中的Fragment实例
        DetailFragment = mFragmentManager.findFragmentByTag("detail_fragment");
        MineFragment = mFragmentManager.findFragmentByTag("mine_fragment");
        // 恢复销毁前显示的Fragment
        setFragment(savedInstanceState.getInt("fragment_id"));
    }

    private void setFragment(int fragment_id) {
        // 获取Fragment管理器
        FragmentManager mFragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragments(mTransaction);
        switch (fragment_id) {
            default:
                break;
            case FRAGMENT_DETAIL:
                mFragmentId = FRAGMENT_DETAIL;
                // 设置菜单栏为选中状态（修改文字和图片颜色）
                mTabDetail.setTextColor(getResources().getColor(R.color.menuCharSelected));
                mTabDetail.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.ic_account_selected,0,0);
                // 显示对应的Fragment
                if (DetailFragment == null) {
                    DetailFragment = new DetailFragment();
                    mTransaction.add(R.id.container, DetailFragment, "detail_fragment");
                } else {
                    mTransaction.show(DetailFragment);
                }
                break;
            case FRAGMENT_MINE:
                mFragmentId = FRAGMENT_MINE;
                mTabMine.setTextColor(getResources().getColor(R.color.menuCharSelected));
                mTabMine.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.ic_mine_selected,0,0);
                if (MineFragment == null) {
                    MineFragment = new MineFragment();
                    mTransaction.add(R.id.container, MineFragment, "mine_fragment");
                } else {
                    mTransaction.show(MineFragment);
                }
                break;
        }
        // 提交事务
        mTransaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (DetailFragment != null) {
            //隐藏Fragment
            transaction.hide(DetailFragment);
            //将对应菜单栏设置为默认状态
            mTabDetail.setTextColor(getResources().getColor(R.color.menuCharNormal));
            mTabDetail.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.ic_account_normal, 0, 0);
        }
        if (MineFragment != null) {
            transaction.hide(MineFragment);
            mTabMine.setTextColor(getResources().getColor(R.color.menuCharNormal));
            mTabMine.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.ic_mine_normal, 0, 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_detail:
                setFragment(FRAGMENT_DETAIL);
                break;
            case R.id.tv_mine:
                setFragment(FRAGMENT_MINE);
                break;
        }
    }
}