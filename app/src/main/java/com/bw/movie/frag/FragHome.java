package com.bw.movie.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.adapter.HomeOneAdapter;
import com.bw.movie.adapter.HomeThreeAdapter;
import com.bw.movie.adapter.HomeTwodapter;
import com.bw.movie.adapter.LoopAdapter;
import com.bw.movie.bean.HomeOneBean;
import com.bw.movie.bean.HomeThree;
import com.bw.movie.bean.HomeTwoBean;
import com.bw.movie.presenter.HomeOnePresenter;
import com.bw.movie.presenter.HomeThreePresenter;
import com.bw.movie.presenter.HomeTwoPresenter;
import com.bw.movie.view.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import recycler.coverflow.RecyclerCoverFlow;

/**
 * @Auther: 郭亚杰
 * @Date:2019/6/10
 * @Description: 影片首页
 */
public class FragHome extends Fragment {
    @BindView(R.id.send_recy)//旋转木马
            RecyclerCoverFlow send_recy;
    @BindView(R.id.rc1)
    RecyclerView rc1;
    @BindView(R.id.rc2)
    RecyclerView rc2;
    @BindView(R.id.rc3)
    RecyclerView rc3;

    private Unbinder unbinder;
    private int imgs[] = {R.mipmap.home_xuanzhuan_tiexue, R.mipmap.home_xuanzhuan_zuori
            , R.mipmap.home_xuanzhuan_wushuang, R.mipmap.home_xuanzhuan_weini,
            R.mipmap.home_xuanzhuan_menglong};
    private LoopAdapter loopAdapter;
    private HomeOnePresenter homeOnePresenter;
    private HomeOneAdapter homeOneAdapter;
    private HomeTwoPresenter homeTwoPresenter;
    private HomeTwodapter homeTwodapter;
    private HomeThreePresenter homeThreePresenter;
    private HomeThreeAdapter homeThreeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraghome, container, false);
        //绑定控件
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //适配器
        loopAdapter = new LoopAdapter(getActivity(), imgs);
        send_recy.setAdapter(loopAdapter);
        //让轮播图显示中间的图片
        send_recy.smoothScrollToPosition(imgs.length / 2);
        //自定义接口回调，点击图片使它展示到中间
        loopAdapter.setOnItemClick(new LoopAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int position) {
                send_recy.smoothScrollToPosition(position);
            }
        });


        //------------------------------------------------------
        //热门电影
        //关联presenter
        homeOnePresenter = new HomeOnePresenter(new HomeOneCall());
        homeOnePresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rc1.setLayoutManager(linearLayoutManager);
        //适配器
        homeOneAdapter = new HomeOneAdapter(getActivity());
        rc1.setAdapter(homeOneAdapter);
        homeOneAdapter.setCall(new HomeOneAdapter.Call() {
            @Override
            public void itemClick() {
                getActivity().finish();
            }
        });

        //正在上映
        //关联presenter
        homeTwoPresenter = new HomeTwoPresenter(new HomeTwoCall());
        homeTwoPresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rc2.setLayoutManager(linearLayoutManager1);
        //适配器
        homeTwodapter = new HomeTwodapter(getActivity());
        rc2.setAdapter(homeTwodapter);
        homeTwodapter.setCall(new HomeTwodapter.Call() {
            @Override
            public void itemClick() {
                getActivity().finish();
            }
        });

        //即将上映
        //关联presenter
        homeThreePresenter = new HomeThreePresenter(new HomeThreeCall());
        homeThreePresenter.requestData();
        //布局管理器
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rc3.setLayoutManager(linearLayoutManager2);
        //适配器
        homeThreeAdapter = new HomeThreeAdapter(getActivity());
        rc3.setAdapter(homeThreeAdapter);
        homeThreeAdapter.setCall(new HomeThreeAdapter.Call() {
            @Override
            public void itemClick() {
                getActivity().finish();
            }
        });
    }

    //热门电影
    class HomeOneCall implements DataCall<List<HomeOneBean>> {
        @Override
        public void success(List<HomeOneBean> data) {
            homeOneAdapter.setData(data);
            homeOneAdapter.notifyDataSetChanged();
        }
    }

    //正在上映
    class HomeTwoCall implements DataCall<List<HomeTwoBean>> {

        @Override
        public void success(List<HomeTwoBean> data) {
            homeTwodapter.setDatat(data);
            homeTwodapter.notifyDataSetChanged();
        }
    }

    //即将上映
    class HomeThreeCall implements DataCall<List<HomeThree>> {

        @Override
        public void success(List<HomeThree> data) {
            homeThreeAdapter.setDatt(data);
            homeThreeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑
        unbinder.unbind();
    }
}
