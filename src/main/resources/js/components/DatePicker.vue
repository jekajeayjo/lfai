<template>
    <v-container>
        <v-row>
            <v-col cols="12" lg="6">
                <v-menu
                        ref="menu1"
                        v-model="menu1"
                        :close-on-content-click="false"
                        transition="scale-transition"
                        offset-y
                        max-width="290px"
                        min-width="290px"
                >
                    <template v-slot:activator="{ on }">
                        <v-text-field
                                v-model="dateFormatted"
                                label="Date"
                                hint="MM/DD/YYYY format"
                                persistent-hint
                                prepend-icon="event"
                                @blur="dateJs = parseDate(dateFormatted)"
                                v-on="on"
                        ></v-text-field>
                    </template>
                    <v-date-picker v-model="dateJs" no-title @input="menu1 = false"></v-date-picker>
                </v-menu>
                <p>Date in ISO format: <strong>{{ dateJs }}:{{dateFormatted}}</strong></p>
            </v-col>

        </v-row>
    </v-container>
</template>

<script>
    import ConvertDate from "../util/ConvertDate";
    const convertDate =new ConvertDate()
    export default {
        name: "DatePicker",
        data() {
            return {

                dateJs: new Date().toISOString().substr(0, 10),
                dateFormatted: this.formatDate(new Date().toISOString().substr(0, 10)),
                menu1: false


            }
        },

        computed: {
            computedDateJs() {
                return this.formatDate(this.dateJs)
            },
        }, watch: {
            dateJs() {

                this.dateFormatted = this.formatDate(this.dateJs)
            },
        },
        methods: {
            formatDate(date) {
                if (!date) return null
                return convertDate.fromJs(date)
            },
            parseDate(date) {
                if (!date) return null
                return convertDate.fromOracle(date)
            },
        },
    }
</script>

<style scoped>

</style>