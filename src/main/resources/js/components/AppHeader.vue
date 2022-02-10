<template>
  <div id="layer2">

<!--    <v-overlay :value="overlay" absolute>-->
<!--    </v-overlay>-->
    <v-app-bar
        app
        light
        color="white"
    >

      <div class="fruit1"  @click="home" />

      <v-spacer></v-spacer>
      <v-card-title>{{ page }}</v-card-title>
      <v-spacer></v-spacer>

      <v-btn text @click.prevent="logout">
        <span class="mr-2">Выход</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <!--        <v-content>-->

    <!--        </v-content>-->
  </div>

</template>

<script>
const path = require('path');
export default {
  name: "AppHeader"
  , props: {
    showlog:
        {
          type: Boolean,
          required: true,
          default: false
        }
  }
  , data() {
    return {
      logoPath: path.join(__dirname, 'src', 'main', 'resources', 'assets', 'logo.png'),
      ss: ''
    }
  },
  computed: {
    overlay() {
      return this.$store.getters.getOverLay
    },
    page() {
      return this.$store.getters.getPageModule
    }
  },
  methods: {
    cleanBread() {
      console.log('asdas')
      this.$store.dispatch('CLEAN_BREAD_CUMP_MENU_LIST')
      this.$router.push('/')
    },
    home()
    {
      this.$router.push('/')
      this.$store.dispatch('CLEAN_BREAD_CUMP_MENU_LIST')
     this.$store. commit('SET_PAGE_MODULE', "Главная")
    },
    logout() {
      //TODO:ВЫХОД
      this.$store.dispatch('CLEAN_BREAD_CUMP_MENU_LIST')
      this.$store.dispatch('SIGN_OUT')
      this.$router.push('/login')
    }
  }

}
</script>

<style scoped>
#layer2 {
  z-index: 99;
}
.fruit1 {
  margin-top: 10px;
  background-image: url('../../assets/logo.png');
  background-size: 200px;
  height:65px;
  width:200px;
  background-repeat:no-repeat;
}
</style>