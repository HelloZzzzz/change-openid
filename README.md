微信公众号粉丝迁移
1、生产环境数据通过导excel的形式给与，
    然后获取token之后调用腾讯接口获取新的openid（https://kf.qq.com/faq/1901177NrqMr190117nqYJze.html）
2、然后匹配到对应的值，生产SQL进行投产。
    excel(.xlsx) ==> .sql



    @Test
    public void executor() throws Exception {
        Executor executor = new ExecutorFactoryBuilder().builder(Resource.getInputStream("src/main/resources/change-openid.properties")).createExecutor();
        executor.handler();
    }


***************************
TODO
1、调取接口失败生产错误日志
2、全局异常处理
3、大文件懒加载


***************************
EXPANSION
1、其他形式的读取数据
2、数据库对数据库






