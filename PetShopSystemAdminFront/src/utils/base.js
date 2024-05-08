const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootpavyhdan/",
            name: "springbootpavyhdan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootpavyhdan/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Spring Boot的安信宠物医疗美容系统"
        } 
    }
}
export default base
