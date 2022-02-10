<template>
  <v-container class="fill-height" fluid>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="8">
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title>Вход в систему</v-toolbar-title>
            <v-spacer/>
          </v-toolbar>
          <v-card-text>
            <v-alert :value="error" type="warning">
              {{ error }}
            </v-alert>
            <v-form v-model="valid">
              <v-text-field v-on:keyup.enter="signin" label="Логин" name="login" prepend-icon="person"
                            type="text" required v-model="login" :rules="loginRules"/>
              <v-text-field v-on:keyup.enter="signin" id="password" label="Пароль" name="password"
                            prepend-icon="lock"
                            :append-icon="typeFieldPass? 'visibility':'visibility_off' "
                            @click:append="typeFieldPass=!typeFieldPass"
                            :type="typeFieldPass ? 'password' : 'text'" required v-model='password'
                            :rules="passwordRules"/>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-btn color="green" @click.prevent="dialog=true">Точка входа</v-btn>
            <v-spacer/>
            <v-btn color="blue" @click.prevent="signin" :disabled=" !valid">Вход</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
    <v-dialog v-model="dialog" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">Точка доступа</span>
        </v-card-title>

        <v-card-text>
          <v-container>
            <v-row>
              <!--              {{serverList}}-->
              <v-col md="12" cols="12">
                <v-combobox no-data-text=""
                            :items="serverList"
                            v-model="currentServer"
                            @change="changeCurrentServer"
                            item-text="name"

                ></v-combobox>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-container>

</template>

<script>
import md5 from 'js-md5'
// import  axios from 'axios'
export default {

  name: "SignIn",
  data() {
    return {
      dialog: false,
      currentServer: {},
      data: {
        header: {
          service: '',
          operation: '',
          hash: ''
        },
        request: {
          username: '',
          password: '',
          data: {
            id: 'eee',
            name: '123445',
            arr: [1, 2, 3, 4, 5]
          }
        }
      },
      typeFieldPass: true,
      login: null,
      password: null,
      valid: false,
      loginRules: [
        (v) => !!v || 'Пожалуйста введите логин'
      ],
      passwordRules: [
        (v) => !!v || 'Пожалуйста введите пароль',
        (v) => (v && v.length > 1) || 'Логин слишком короткий - минимум 6 символов'
      ]
    }
  },
  computed: {
    error() {
      //getters обьявляем ка кпростые переменные
      return this.$store.getters.getError
    },
    processing() {
      return this.$store.getters.getProcessing
    },
    isAuthenticated() {
      return this.$store.getters.isUserAuthenticated
    },
    serverList() {
      return this.$store.getters.getServerList
    },
    getCurrentServer() {
      return this.$store.getters.getCurrentServer
    }
  },
  watch: {
    // watch  имя должно совпадат с именем computed
    isAuthenticated(val) {
      if (val === true)
        this.$router.push("/")
    }
  },
  created() {
    this.currentServer = this.getCurrentServer
  },
  methods: {
    //не писать по возможности с верхним регистром
    //ругается на регистр выдает ошибу
    signin() {
      this.data.header.service = 'auth',
          this.data.header.operation = 'logon',
          this.data.request.username = this.login,
          this.data.request.password = md5(this.password).toUpperCase()
      this.data.header.hash = md5(JSON.stringify(this.data.request)).toUpperCase()
// axios.post('http://25.133.210.152:8888/ods/query',this.data)
//                 .then(response => {console.log(response.data)})

      // this.$store.dispatch('SIGN_IN', {login: this.login, password: this.password})
      this.$store.dispatch('SIGN_IN', {data: this.data})
    },
    changeCurrentServer() {
      console.log(this.currentServer)
      this.$store.dispatch('SET_CURRENT_SERVER', {
        data: this.currentServer,

      })
      this.dialog = false
    }
  }
}
</script>

<style scoped>

</style>