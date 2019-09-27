package adventofcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import testjava.*;
public class CheckSUm_2Test {
	@Test
	public void testsolve() {
		CheckSUm_2 cke= new CheckSUm_2();
		int a= cke.solve2("5\t1\t9\t5\n" + "7\t5\t3\n" + "2\t4\t6\t8");
		assertTrue(a==18);
	}
	@Test
	public void testsolve2() {
		CheckSUm_2 cke= new CheckSUm_2();
		int a= cke.solve2("1236\t741\t557\t1029\t144\t101\t1968\t2159\t1399\t80\t1139\t1167\t1695\t82\t90\t2236\n" +
                "2134\t106\t107\t1025\t584\t619\t191\t496\t80\t352\t351\t2267\t1983\t1973\t97\t1244\n" +
                "3227\t179\t691\t3177\t172\t1636\t3781\t2020\t3339\t2337\t189\t3516\t1500\t176\t159\t3279\n" +
                "201\t688\t364\t180\t586\t659\t623\t577\t188\t265\t403\t670\t195\t720\t115\t37\n" +
                "1892\t1664\t2737\t2676\t849\t2514\t923\t171\t311\t218\t255\t2787\t1271\t188\t1278\t2834\n" +
                "150\t3276\t204\t603\t3130\t587\t3363\t3306\t2890\t127\t176\t174\t383\t3309\t213\t1620\n" +
                "5903\t3686\t200\t230\t6040\t4675\t6266\t179\t5375\t1069\t283\t82\t6210\t6626\t6398\t1954\n" +
                "942\t2324\t1901\t213\t125\t2518\t655\t189\t2499\t160\t2841\t2646\t198\t173\t1841\t200\n" +
                "232\t45\t272\t280\t44\t248\t50\t266\t296\t297\t236\t254\t58\t212\t276\t48\n" +
                "563\t768\t124\t267\t153\t622\t199\t591\t204\t125\t93\t656\t198\t164\t797\t506\n" +
                "243\t4746\t1785\t204\t568\t4228\t2701\t4303\t188\t4148\t4831\t1557\t4692\t166\t4210\t3656\n" +
                "72\t514\t1572\t172\t1197\t750\t1392\t1647\t1587\t183\t1484\t213\t1614\t718\t177\t622\n" +
                "1117\t97\t2758\t2484\t941\t1854\t1074\t264\t2494\t83\t1434\t96\t2067\t2825\t2160\t92\n" +
                "2610\t1290\t204\t2265\t1374\t2581\t185\t852\t207\t175\t3308\t1500\t2898\t1120\t1892\t3074\n" +
                "2322\t1434\t301\t2156\t98\t2194\t587\t1416\t1521\t94\t1985\t424\t91\t119\t1869\t1073\n" +
                "66\t87\t176\t107\t2791\t109\t21\t92\t3016\t2239\t1708\t3175\t3210\t2842\t446\t484");
		assertTrue(a==277);
	}
	@Test
	public void testsolve3() {
		CheckSUm_2 cke= new CheckSUm_2();
		int a= cke.solve2("5\t1\t9\t5\n" + "" + "2\t4\t6\t8");
		assertTrue(a==18);
	}
	@Test
	public void testsolve4() {
		CheckSUm_2 cke= new CheckSUm_2();
		int a= cke.solve2("5\t2\t9\t5\n");
		assertTrue(a==0);
	}
}
