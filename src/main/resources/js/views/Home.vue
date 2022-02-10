<template>

    <div>

        <div class="container"  v-if="getNews.length!=0">
            <v-dialog v-model="dialog" max-width="900px">

                <v-card>
                    <v-card-title

                            class="headline grey lighten-2"
                            primary-title


                    >
                        <p style="color: cornflowerblue"> {{item.subject}}</p>
                        <v-spacer></v-spacer>
                        <v-btn color="red darken-1" text @click="close">
                            <v-icon>highlight_off</v-icon>
                        </v-btn>
                    </v-card-title>




                    <v-card-text>
                        <v-container>
                            <v-row>
                                <v-col cols="12" sm="6" md="12">
                                    <h2 v-html="item.body"><i>{{}}</i></h2>
                                </v-col>


                            </v-row>
                        </v-container>
                    </v-card-text>

                    <v-card-actions>
                        <i style="color: cornflowerblue"> {{item.date}}</i>
                        <v-spacer></v-spacer>
                        <v-btn v-if="item.is_del!=0" color="red darken-1" text @click="deleteItem(item)">
                            Удалить
                            <v-icon>delete</v-icon>
                        </v-btn>
                        <v-btn v-if="item.url!=''" color="blue darken-1" text @click="transition(item)">
                            Перейти
                            <v-icon>label_important</v-icon>
                        </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
            <v-row>
                <!--       новосты начало -->
                <v-col
                        cols="12"
                        md="6"
                        v-for="news  in getNews" :key="news.id"
                >

                    <v-card :elevation="5">
                        <v-row>
                            <v-col class="ml-2" cols="12" md="5">

                                <v-img v-if="news.img=='worker'"
                                        alt="Vuetify Logo"
                                        class="shrink mr-2"
                                        contain
                                        src="../assets/worker.jpg"
                                        transition="scale-transition"

                                        height="190"
                                />
                                <v-img v-if="news.img=='company'"
                                       alt="Vuetify Logo"
                                       class="shrink mr-2"
                                       contain
                                       src=""
                                       transition="scale-transition"

                                       height="190"
                                />
                                <v-img v-if="news.img=='branche'"
                                       alt="Vuetify Logo"
                                       class="shrink mr-2"
                                       contain
                                       src="../assets/fillial.jpg"
                                       transition="scale-transition"

                                       height="190"
                                />
                            </v-col>
                            <v-divider vertical class="mx-1"></v-divider>
                            <v-col cols="12" md="6">
                                <p class="text-right"> {{news.date}}</p>
                                <v-card-text>

                                    <h2 class=" mb-1 text-center" style="color: goldenrod">{{news.subject}} </h2>
                                    <p class=" ">


                                    </p>
                                    <v-btn class="ma-2" text color="blue" @click="getBodyNews(news)">
                                        <v-icon left>call_made</v-icon>
                                        Подробнее
                                    </v-btn>
                                </v-card-text>
                            </v-col>

                        </v-row>

                    </v-card>
                </v-col>
                <!--        новость конец-->


            </v-row>
        </div>
      <div v-else>
       <v-row  align="center" justify="center">
         <v-col md="5" >
           <div class="homeEmpty"   />
         </v-col>
       </v-row>
      </div>
    </div>
</template>

<script>
    import MDHash from "../util/MD5";
    import md5 from "js-md5";

    const mD5HashService = new MDHash()
    export default {
        name: 'Home',
        components: {}
        , data() {
            return {
                item: {
                    id: '',
                    date: '',
                    subject: '',
                    body: '',
                    parent: '',
                    url: '',
                    is_del: '',
                    img: '',
                },
                dialog: '',
                colors: [
                    'indigo',
                    'warning',
                    'pink darken-2',
                    'red lighten-1',
                    'deep-purple accent-4',
                ],
                slides: [
                    'First',
                    'Second',
                    'Third',
                    'Fourth',
                    'Fifth',
                ],
                reques: {
                    header: {
                        service: "news",
                        operation: "show.list",
                        sessionid: null,
                        hash: null
                    },
                    request: {}
                },
                requestNewsDetail: {
                    header: {
                        service: "news",
                        operation: "show.get",
                        sessionid: null,
                        hash: null
                    },
                    request: {}
                },
                requestNewsDetailDelete: {
                    header: {
                        service: "news",
                        operation: "show.delete",
                        sessionid: null,
                        hash: null
                    },
                    request: {}
                }
            }
        },
        computed: {
            getSessionID() {
                //getters обьявляем ка кпростые переменны
                return this.$store.getters.getSessionId
            },
            getNews() {
                //getters обьявляем ка кпростые переменны
                return this.$store.getters.getNews
            }
        },
        created() {
            //тут получение меню
            this.getNewsList()
        },
        methods: {
            getBodyNews(item) {
                this.item = item

                this.requestNewsDetail.header.sessionid = this.getSessionID
                this.requestNewsDetail.request.id = item.id
                this.requestNewsDetail.header.hash = mD5HashService.MD5(JSON.stringify(this.requestNewsDetail.request)).toUpperCase(),
                    console.log('reques news detail ', this.reques)
                this.$store.dispatch('GET_NEWS_DETAIL', {
                    data: this.requestNewsDetail,
                    getNewsDetail: this.getNewsDetail
                })
            },
            getNewsDetail(body) {
                this.item.body = body
                this.dialog = true
            },
            close() {
                this.dialog = false
            },
            transition(item) {
                console.log(item)
                if (item.url.substring(0,1)=='/')
                {
                    this.$router.push(item.url)
                }
                else
                {
                    window.open(item.url, "_blank");
                }

            },
            getNewsList() {
                this.reques.header.sessionid = this.getSessionID
                this.reques.header.hash = mD5HashService.MD5(JSON.stringify(this.reques.request)).toUpperCase(),
                    console.log('reques news ', this.reques)
                this.$store.dispatch('GET_NEWS', {data: this.reques})

            },
            deleteItem(item) {
                console.log('tt', item)
                this.$swal({
                    title: "Очистка",
                    text: "Вы действительно хотите удалить новость?",
                    icon: "warning",
                    buttons: {
                        cancel: "Нет",
                        catch: {

                            text: "Да",
                            value: true,
                        },
                    },
                    dangerMode: true,

                })
                    .then((willDelete) => {
                        if (willDelete) {
                            console.log('item', item)
                            this.editedItem = item
                            this.requestNewsDetailDelete.header.sessionid = this.getSessionID
                            this.requestNewsDetailDelete.request.id = item.id
                            this.requestNewsDetailDelete.header.hash = md5(JSON.stringify(this.requestNewsDetailDelete.request)).toUpperCase()
                            console.log('delete', this.requestNewsDetailDelete)
                            this.$store.dispatch('DELETE_NEWS_DETAIL', {
                                data: this.requestNewsDetailDelete,
                                statusSucces: this.statusDeleteSucces,
                                statusError: this.statusDeleteError
                            })

                        }
                    });
            },
            statusDeleteSucces() {
                this.getNewsList()
                this.dialog = false
                this.$swal("Выполнено успешно!", {
                    icon: "success",
                });


            },
            statusDeleteError() {
                this.$swal({
                    title: "Удаление",
                    text: this.error,
                    icon: "warning"
                });
            },
        }
    }
</script>
<style>
.homeEmpty {
  margin-top: 10px;
  background-image: url('../../assets/logo.png');

  height:200px;
  width:1100px;
  background-repeat:no-repeat;
}
</style>
