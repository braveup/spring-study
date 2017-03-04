import com.google.common.collect.Lists;
import com.spring.main.po.Books;
import com.spring.main.po.Helloword;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.PromotionCouponSendRequest;
import com.taobao.api.request.QianniuKefuevalGetRequest;
import com.taobao.api.response.PromotionCouponSendResponse;
import com.taobao.api.response.QianniuKefuevalGetResponse;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by braveup on 2017/2/21.
 */

public class TaoBaoTest {
    private String url = "http://gw.api.taobao.com/router/rest";
    //    private String url = "http://127.0.0.1:8080/router/rest";
    private String appkey = "12301235";
    private String secret = "4ae07a406609e37978dbae8d4c38d813";
    //    private String appkey = "12283535";
//    private String secret = "4283e0d7a760229ab34bca67cc87fcf2";
    private String sessionKey = "620251976c87caa319ea9952ac4ZZa2cb4b3b86d6d7b3441849722037";
    private String user_key = "梅梅1396";
    private long current_page = 1L;

    //    /**
//     *千牛数字中心测试
//     */
//    @Test
//    private void  testShuZiZhongXin(){
//        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//        QianniuNumberPutRequest req = new QianniuNumberPutRequest();
//        req.setData("[{user_id:384652432,field:“jinridingdanshu”,value:“2.0”},{ user_id:384652432, field:“zuoridingdanshu”,value:”2.0“}]");
//        QianniuNumberPutResponse rsp = client.execute(req);
//        System.out.println(rsp.getBody());
//    }
    @Test
    public void testCoupon() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        PromotionCouponSendRequest req = new PromotionCouponSendRequest();
        req.setCouponId(502815017L);
        req.setBuyerNick("braveup感恩");
        PromotionCouponSendResponse rsp = client.execute(req, "620002062e8d32d23df752011602ZZ27717287e255caf221849722037");
        System.out.println(rsp.getBody());
    }
    @Test
    public  void test() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        QianniuKefuevalGetRequest req = new QianniuKefuevalGetRequest();
        req.setQueryIds("cntaobao数云食堂:西安开发4:1");
        req.setBtime("20170222104032");
        req.setEtime("20170228104037");
        QianniuKefuevalGetResponse rsp=client.execute(req,sessionKey);
        System.out.println(rsp.getBody());

    }


}



