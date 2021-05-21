import Vue from "vue";
import VueRouter from "vue-router";
import List from "@/components/List.vue";
import Create from "@/components/Create.vue";
import Search from "@/components/Search.vue";
import Update from "@/components/Update.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/happyhouse/article",
    name: "List",
    component: List
  },

  {
    path: "/happyhouse/article/write",
    name: "Create",
    component: Create
  },
  {
    path: "/happyhouse/article",
    name: "Search",
    component: Search
  },
  {
    path: "/happyhouse/article/update",
    name: "Update",
    component: Update
  },
  // {
  //   path: "/happyhouse/article/remove",
  //   name: "Remove",
  //   component: Remove
  // }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;