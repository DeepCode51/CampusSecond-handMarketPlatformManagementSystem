const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootz5q40/",
            name: "springbootz5q40",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootz5q40/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园二手市场平台"
        } 
    }
}
export default base
