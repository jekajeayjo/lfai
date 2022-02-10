<template>


  <v-navigation-drawer
      id="layer1"
      style="border-right: 1px solid #9b0101;
"
      v-model="drawer"
      :width="350"
      expand-on-hover
      mini-variant
      absolute
      dark
      permanent
      overlay-color="white"
      class="pt-12"
      color="#444"
  >

    <!--        мое меню-->

    <v-list
        dense
        nav
        class="py-0"
        shaped

    >
      <div class="mt-7">
        <!--            <v-divider class=""></v-divider>-->
        <div v-for="link  in getMenu" :key="link.name"

        >
          <!-- первый уровень-->
          <v-list-item
              @click="setPageModule(link);"
              v-if="link.url!=''"
              link :to="link.url"
              avatar

          >

            <v-list-item-icon>
              <v-icon>{{ link.img }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ link.name }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <!--переходим на второй урвоень-->
          <v-list-group
              v-else
              no-action
              :color="'#b1cd33'"
          >

            <template
                v-slot:activator>
              <v-list-item-icon>
                <v-icon>{{ link.img }}</v-icon>
              </v-list-item-icon>

              <v-list-item-content>
                <v-list-item-title style="font-weight: bold;font-size: 14px">{{ link.name }}</v-list-item-title>
              </v-list-item-content>
            </template>
            <!--отобразить данные второго уровня-->
            <div v-for="sublink  in link.children" :key="sublink.name">

              <!--отобразить список элементов второго уровня-->
              <v-list-item
                  @click="setPageModule(sublink)"
                  v-if="sublink.url!=''"
                  link :to="sublink.url"
                  :key="sublink.name"
                  :color="'green'"
              >
                <v-list-item-content>
                  <v-list-item-title>{{ sublink.name }}</v-list-item-title>
                </v-list-item-content>
                <v-list-item-icon>
                  <v-icon>{{ sublink.img }}</v-icon>
                </v-list-item-icon>
              </v-list-item>

              <!--                        отобразить список групп третьего уровня-->
              <v-list-group
                  :sub-group="sublink.children"
                  v-else
                  no-action
                  :color="'red'"
              >

                <template
                    v-slot:activator>
                  <v-list-item-icon>
                    <v-icon>{{ sublink.img }}</v-icon>
                  </v-list-item-icon>

                  <v-list-item-content>
                    <v-list-item-title style="font-weight: bold;font-size: 14px">{{ sublink.name }}</v-list-item-title>
                  </v-list-item-content>
                </template>
                <!--отобразить список элементов 3 уровня-->
                <v-list-item
                    :color="'yellow'"
                    @click="setPageModule(sub3link)"
                    v-for="sub3link in sublink.children"
                    link :to="sub3link.url"
                    :key="sub3link.name"
                >

                  <v-list-item-icon>
                    <v-icon>{{ sub3link.img }}</v-icon>
                  </v-list-item-icon>

                  <v-list-item-content>
                    <v-list-item-title>{{ sub3link.name }}</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>


              </v-list-group>
            </div>

          </v-list-group>
        </div>
      </div>
    </v-list>
  </v-navigation-drawer>


</template>
<script>
import md5 from 'js-md5'

export default {
  components: {},
  data() {
    return {
      drawer: true,
      items: null,


      color: 'gray',
      colors: [
        'primary',
        'blue',
        'success',
        'red',
        'teal',
      ],
      right: false,
      miniVariant: true,
      expandOnHover: true,
      background: false,
    }
  },
  computed: {
    overlay() {
      return this.$store.getters.getOverLay
    },
    bg() {
      return this.background ? 'https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg' : undefined
    }
    ,
    getSessionID() {
      //getters обьявляем ка кпростые переменны
      return this.$store.getters.getSessionId
    },
    getMenu() {
      //getters обьявляем ка кпростые переменны
      return this.$store.getters.getMenu
    }

  },
  created() {

    //тут получение меню
    console.log('get Menu List');
    this.getMenuList();

  },
  methods: {
    getMenuList() {
      this.$store.dispatch('SEND_REQUEST_GET', {
        url: '/dictionary/menu-list'
      })
    },
    setBreadCump(item) {
      console.log('breadcump', item)
      this.$store.dispatch('SET_BREAD_CUMP_MENU_LIST', {data: item})
    },
    setPageModule(item) {
      this.$store.dispatch("IS_HAPPENING_MENU", {data: false})
      console.log('page_module', item)
      this.$store.dispatch('SET_PAGE_MODULE', {
        pageModule: item.name
      })
      this.$store.dispatch('SET_CHOOSED_ITEM_MENU', {
        data: item
      })
      this.setBreadCump(item)
    },
    MD5: function (d) {
      var r = this.M(this.V(this.Y(this.X(d), 8 * d.length)));
      return r.toLowerCase()
    },

    M: function (d) {
      for (var _, m = "0123456789ABCDEF", f = "", r = 0; r < d.length; r++) _ = d.charCodeAt(r), f += m.charAt(_ >>> 4 & 15) + m.charAt(15 & _);
      return f
    },

    X: function (d) {
      for (var _ = Array(d.length >> 2), m = 0; m < _.length; m++) _[m] = 0;
      for (m = 0; m < 8 * d.length; m += 8) _[m >> 5] |= (255 & d.charCodeAt(m / 8)) << m % 32;
      return _
    },

    V: function (d) {
      for (var _ = "", m = 0; m < 32 * d.length; m += 8) _ += String.fromCharCode(d[m >> 5] >>> m % 32 & 255);
      return _
    }
    ,
    Y: function (d, _) {
      d[_ >> 5] |= 128 << _ % 32, d[14 + (_ + 64 >>> 9 << 4)] = _;
      for (var m = 1732584193, f = -271733879, r = -1732584194, i = 271733878, n = 0; n < d.length; n += 16) {
        var h = m, t = f, g = r, e = i;
        f = this.md5_ii(f = this.md5_ii(f = this.md5_ii(f = this.md5_ii(f = this.md5_hh(f = this.md5_hh(f = this.md5_hh(f = this.md5_hh(f = this.md5_gg(f = this.md5_gg(f = this.md5_gg(f = this.md5_gg(f = this.md5_ff(f = this.md5_ff(f = this.md5_ff(f = this.md5_ff(f, r = this.md5_ff(r, i = this.md5_ff(i, m = this.md5_ff(m, f, r, i, d[n + 0], 7, -680876936), f, r, d[n + 1], 12, -389564586), m, f, d[n + 2], 17, 606105819), i, m, d[n + 3], 22, -1044525330), r = this.md5_ff(r, i = this.md5_ff(i, m = this.md5_ff(m, f, r, i, d[n + 4], 7, -176418897), f, r, d[n + 5], 12, 1200080426), m, f, d[n + 6], 17, -1473231341), i, m, d[n + 7], 22, -45705983), r = this.md5_ff(r, i = this.md5_ff(i, m = this.md5_ff(m, f, r, i, d[n + 8], 7, 1770035416), f, r, d[n + 9], 12, -1958414417), m, f, d[n + 10], 17, -42063), i, m, d[n + 11], 22, -1990404162), r = this.md5_ff(r, i = this.md5_ff(i, m = this.md5_ff(m, f, r, i, d[n + 12], 7, 1804603682), f, r, d[n + 13], 12, -40341101), m, f, d[n + 14], 17, -1502002290), i, m, d[n + 15], 22, 1236535329), r = this.md5_gg(r, i = this.md5_gg(i, m = this.md5_gg(m, f, r, i, d[n + 1], 5, -165796510), f, r, d[n + 6], 9, -1069501632), m, f, d[n + 11], 14, 643717713), i, m, d[n + 0], 20, -373897302), r = this.md5_gg(r, i = this.md5_gg(i, m = this.md5_gg(m, f, r, i, d[n + 5], 5, -701558691), f, r, d[n + 10], 9, 38016083), m, f, d[n + 15], 14, -660478335), i, m, d[n + 4], 20, -405537848), r = this.md5_gg(r, i = this.md5_gg(i, m = this.md5_gg(m, f, r, i, d[n + 9], 5, 568446438), f, r, d[n + 14], 9, -1019803690), m, f, d[n + 3], 14, -187363961), i, m, d[n + 8], 20, 1163531501), r = this.md5_gg(r, i = this.md5_gg(i, m = this.md5_gg(m, f, r, i, d[n + 13], 5, -1444681467), f, r, d[n + 2], 9, -51403784), m, f, d[n + 7], 14, 1735328473), i, m, d[n + 12], 20, -1926607734), r = this.md5_hh(r, i = this.md5_hh(i, m = this.md5_hh(m, f, r, i, d[n + 5], 4, -378558), f, r, d[n + 8], 11, -2022574463), m, f, d[n + 11], 16, 1839030562), i, m, d[n + 14], 23, -35309556), r = this.md5_hh(r, i = this.md5_hh(i, m = this.md5_hh(m, f, r, i, d[n + 1], 4, -1530992060), f, r, d[n + 4], 11, 1272893353), m, f, d[n + 7], 16, -155497632), i, m, d[n + 10], 23, -1094730640), r = this.md5_hh(r, i = this.md5_hh(i, m = this.md5_hh(m, f, r, i, d[n + 13], 4, 681279174), f, r, d[n + 0], 11, -358537222), m, f, d[n + 3], 16, -722521979), i, m, d[n + 6], 23, 76029189), r = this.md5_hh(r, i = this.md5_hh(i, m = this.md5_hh(m, f, r, i, d[n + 9], 4, -640364487), f, r, d[n + 12], 11, -421815835), m, f, d[n + 15], 16, 530742520), i, m, d[n + 2], 23, -995338651), r = this.md5_ii(r, i = this.md5_ii(i, m = this.md5_ii(m, f, r, i, d[n + 0], 6, -198630844), f, r, d[n + 7], 10, 1126891415), m, f, d[n + 14], 15, -1416354905), i, m, d[n + 5], 21, -57434055), r = this.md5_ii(r, i = this.md5_ii(i, m = this.md5_ii(m, f, r, i, d[n + 12], 6, 1700485571), f, r, d[n + 3], 10, -1894986606), m, f, d[n + 10], 15, -1051523), i, m, d[n + 1], 21, -2054922799), r = this.md5_ii(r, i = this.md5_ii(i, m = this.md5_ii(m, f, r, i, d[n + 8], 6, 1873313359), f, r, d[n + 15], 10, -30611744), m, f, d[n + 6], 15, -1560198380), i, m, d[n + 13], 21, 1309151649), r = this.md5_ii(r, i = this.md5_ii(i, m = this.md5_ii(m, f, r, i, d[n + 4], 6, -145523070), f, r, d[n + 11], 10, -1120210379), m, f, d[n + 2], 15, 718787259), i, m, d[n + 9], 21, -343485551), m = this.safe_add(m, h), f = this.safe_add(f, t), r = this.safe_add(r, g), i = this.safe_add(i, e)
      }
      return Array(m, f, r, i)
    },

    md5_cmn: function (d, _, m, f, r, i) {
      return this.safe_add(this.bit_rol(this.safe_add(this.safe_add(_, d), this.safe_add(f, i)), r), m)
    },

    md5_ff: function (d, _, m, f, r, i, n) {
      return this.md5_cmn(_ & m | ~_ & f, d, _, r, i, n)
    }
    ,
    md5_gg: function (d, _, m, f, r, i, n) {
      return this.md5_cmn(_ & f | m & ~f, d, _, r, i, n)
    }
    ,
    md5_hh: function (d, _, m, f, r, i, n) {
      return this.md5_cmn(_ ^ m ^ f, d, _, r, i, n)
    }
    ,
    md5_ii: function (d, _, m, f, r, i, n) {
      return this.md5_cmn(m ^ (_ | ~f), d, _, r, i, n)
    }
    ,
    safe_add: function (d, _) {
      var m = (65535 & d) + (65535 & _);
      return (d >> 16) + (_ >> 16) + (m >> 16) << 16 | 65535 & m
    }
    ,
    bit_rol: function (d, _) {
      return d << _ | d >>> 32 - _
    }
    ,
    convertObjectToJson(data) {
      let keyArr = []
      let valArr = []
      for (var key in data) {

        keyArr.push(key)
      }

      keyArr = keyArr.sort()
      keyArr.forEach((item) => {

        if (typeof (data[item]) !== 'undefined') {
          valArr.push(item + data[item])
        }
      })

      let str = valArr.join('') + this.flagid
      console.log('str ', this.flagid)
      return md5(str)
    }
  }

}
</script>
<style scoped>

#layer1 {
  z-index: 80;
}
</style>