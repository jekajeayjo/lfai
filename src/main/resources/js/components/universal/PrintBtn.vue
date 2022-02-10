<template>
  <v-btn :disabled="isPrint==0" class="mr-1 mb-5" bottom color="blue" @click="choosePrintType()">Печать</v-btn>

</template>

<script>
import md5 from "js-md5";

export default {
  name: "PrintBtn",
  props: {
    id: '',
    form: ''
  },
  data() {
    return {
      isPrint: 0,
      requestCheckPrint: {
        header: {
          service: "print",
          operation: "check",
          sessionid: null,
          hash: null
        },
        request: {}
      },
      requestPrint: {
        header: {
          service: "print",
          operation: "do",
          sessionid: null,
          hash: null
        },
        request: {}
      },
    }
  },
  computed: {
    reosurcePrint()
    {
      return this.$store.getters.getResourcePrint
    },
    choosedItemMenu()
    {
      return this.$store.getters.getChoosedItemMenu
    },
    getSessionID() {
      return this.$store.getters.getSessionId
    },
  },
  created() {
    this.checkPrint()
  },
  methods: {
    checkPrint() {
      this.requestCheckPrint.header.sessionid = this.getSessionID
      this.requestCheckPrint.request.module = this.choosedItemMenu.url
      this.requestCheckPrint.request.form = 'HapeningActOrder'
      this.requestCheckPrint.header.hash = md5(JSON.stringify(this.requestCheckPrint.request)).toUpperCase()


      this.$store.dispatch('GET_ITEM', {
        data: this.requestCheckPrint,
        showRows: this.showPrint


      })
    },

    showPrint(item) {
      console.log(item)
      this.isPrint = item.print
    },
    choosePrintType() {
      this.requestPrint.header.sessionid = this.getSessionID
      this.requestPrint.request.id = this.id
      this.requestPrint.request.module = this.choosedItemMenu.url
      this.requestPrint.request.form = this.form
      this.requestPrint.header.hash = md5(JSON.stringify(this.requestPrint.request)).toUpperCase()

      console.log('requestPrint', this.requestPrint)
      this.$store.dispatch('GET_ITEM', {
        data: this.requestPrint,
        showRows: this.showChoosePrintType


      })
    },
    showChoosePrintType(item) {
      console.log(item)
      window.open(this.reosurcePrint + '?id=' + item.id, '_blank');
    },
  }
}
</script>

<style scoped>

</style>