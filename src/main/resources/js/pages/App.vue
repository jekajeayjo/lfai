<template>
  <v-app>
    <v-overlay :value="overlay" absolute>
    </v-overlay>
<!--    <app-header v-if="showLeftMenu==true &&$route.name!='OsagoPmrDetailInfo' " :showlog="showLeftMenu"/>-->
<!--    <app-left-menu v-if="showLeftMenu==true &&$route.name!='OsagoPmrDetailInfo'"/>-->
<!--    <happening-r-igh-menu v-if="isHappenMenu==true" class="mt-12"></happening-r-igh-menu>-->
<!--    <harmed-menu v-if="isHarmedMenu==true"></harmed-menu>-->
    <v-content class="ml-12">
      <v-alert :value="error" type="warning">
        {{ error }}
      </v-alert>


      <!--            <v-container>-->
      <v-breadcrumbs v-if="$route.name!='OsagoPmrDetailInfo'" :items="breadCumpList">
        <template v-slot:divider>
          <v-icon>mdi-chevron-right</v-icon>
        </template>
      </v-breadcrumbs>
      <!--{{$route.name}}-->
      <!--           {{$route}}-->
      <router-view/>
      <!--            </v-container>-->

      <FlashMessage></FlashMessage>
    </v-content>
  </v-app>
</template>

<script>
//
//import AppHeader from "../components/AppHeader.vue";
//import AppLeftMenu from "../components/AppLeftMenu.vue";
//import HappeningRIghMenu from "../views/contracts/happening/HappeningRIghMenu.vue";
//import HarmedMenu from "../views/contracts/happening/happeningtType/osago/typeharmed/HarmedMenu.vue";
export default {
  name: 'App',

  components: {
    // AppHeader,
    // AppLeftMenu,
    // HappeningRIghMenu,
    // HarmedMenu

  },

  mounted() {



  },
  computed: {
    routName() {
      console.log('routNmae')
      return this.$route.name
    },
    breadCumpList() {
      //getters обьявляем ка кпростые переменны
      return this.$store.getters.getBreadCumpMenuList
    },
    overlay() {
      return this.$store.getters.getOverLay
    },
    isauthenticated() {
      return this.$store.getters.isUserAuthenticated
    },
    error() {
      //getters обьявляем ка кпростые переменные
      return this.$store.getters.getError
    },
    isHappenMenu() {
      return this.$store.getters.getIsHappenMenu
    },
    isHarmedMenu()
    {
      return this.$store.getters.getIsHarmedMenu
    }

  },
  watch: {

    isauthenticated(val) {
      if (val === true)
        this.showLeftMenu = true
      else
        this.showLeftMenu = false
    }
  },
  data() {
    return {
      showLeftMenu: false
    }
  },
  beforeMount() {
    window.addEventListener("load", this.onLoad);
    window.addEventListener("beforeunload", this.onUnload);
  },
  beforeDestroy() {
    window.removeEventListener("load", this.onLoad);
    window.removeEventListener("beforeunload", this.onUnload);
  },
  methods:{
    onLoad(event) {
      window.localStorage.setItem("isMySessionActive", true);
    },
    onUnload(event) {
      // localStorage.removeItem('vuex')
      window.localStorage.setItem("isMySessionActive", false);
    }
  }
};
</script>
