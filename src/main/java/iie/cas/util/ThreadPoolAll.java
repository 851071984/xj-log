package iie.cas.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class ThreadPoolAll {
	static final ExecutorService pool = Executors.newCachedThreadPool();
	public static void loadDrivers(Runnable dri) {
		
        for(int i=0;i<1;i++){
         pool.submit(dri);
        }
//        pool.shutdown();  //关闭线程池
        //线程是否已全部关闭
//        while (!pool.isTerminated()) {  
//            
//        }  
	}
}
