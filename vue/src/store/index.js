import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";
Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        articles: [], //전체 게시글
        article: {}, //update, search할때 현재 보는 게시글
        replies: [], //댓글 목록
        session: {},
        pageParams: {
            key: "",
            word: "",
            page: 1,
            articleType: "",
        },
    },
    getters: {
        articles(state) {
            console.log("index.js getters articles ", state.articles);
            return state.articles;
        },
        article(state) {
            console.log("index.js getters article ", state.article);
            return state.article;
        },
        replies(state) {
            console.log("[getter] Replies " + state.replies);
            return state.replies;
        },
        session(state) {
            console.log("[getter] session");
            console.log(state.session);
            return state.session;
        },
        pageParams(state) {
            return state.pageParams;
        },
    },
    mutations: {
        setArticles(state, payload) {
            state.articles = payload;
        },
        setArticle(state, payload) {
            state.article = payload;
        },
        setReplies(state, payload) {
            console.log("[mutation] reply " + state.replies);
            state.replies = payload;
        },
        setSession(state, payload) {
            console.log("[mutation session]");
            state.session = payload;
        },
        setPageParams(state, payload) {
            state.pageParams = payload;
        },
    },
    actions: {
        getArticles(context) {
            console.log(`state :  `);
            console.log(context.state.pageParams.articleType);
            let params = context.state.pageParams;
            http.get("/article/list", { params })
                .then((response) => {
                    console.log("get articles resonse: ", response);
                    context.commit("setArticles", response.data);
                    console.log("get articles response.data: ", response.data);
                })
                .catch(() => {
                    alert("수행 중 오류가 발생했습니다.");
                });
        },
        getArticle(context, payload) {
            http.get(payload)
                .then(({ data }) => {
                    console.log(
                        `index.js getArticle then commit data: ${data}`
                    );
                    context.commit("setArticle", data);
                })
                .catch(() => {
                    alert("오류 발생");
                });
        },

        getReplies(context, payload) {
            console.log("getReplies");
            http.get(payload)
                .then(({ data }) => {
                    console.log(`getReply then commit data: ${data}`);
                    context.commit("setReplies", data);
                })
                .catch(() => {
                    alert("reply 불러오기 오류 발생");
                });
        },
        getSession(context) {
            console.log("[action] getSession");
            http.get(`/getSession`)
                .then(({ data }) => {
                    context.commit("setSession", data);
                })
                .catch(() => {
                    alert("session 오류");
                });
        },
        getPageParams(context, payload) {
            console.log("[action] getPageParams");
            console.log(payload);
            context.commit("setPageParams", payload);
        },
    },
});
