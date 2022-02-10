<template>
    <v-container>
        <v-card>
            <v-row class="ma-2">
                <v-col offset="5" md="5">
                    <v-card-title>
                        <v-toolbar-title>Заявление</v-toolbar-title>
                    </v-card-title>
                </v-col>

                <v-col cols="12" sm="6" md="5">

                    <v-text-field
                            prepend-icon="account_box"
                          autofocus
                            label="Имя заявителя"
                            outlined
                            clearable
                    ></v-text-field>
                </v-col>
                <v-col cols="12" md="5" offset="1">

                    <v-menu

                            v-model="fromDateMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            transition="scale-transition"
                            offset-y
                            max-width="290px"
                            min-width="290px"

                    >

                        <template v-slot:activator="{ on }">

                            <v-text-field
                                    label="Дата заявления"
                                    prepend-icon="event"
                                    readonly
                                    v-model="computedDateFormatted"
                                    v-on="on"
                                    :outlined="true"
                                    clearable

                            ></v-text-field>
                        </template>
                        <v-date-picker
                                locale="ru-in"
                                v-model="fromDateVal"
                                no-title
                                @input="fromDateMenu = false"
                                :min="minDate"
                        ></v-date-picker>
                    </v-menu>
                </v-col>
                <v-col cols="12" sm="6" md="5">
                    <v-file-input multiple label="Файл" outlined></v-file-input>
                </v-col>

            </v-row>
        </v-card>
    </v-container>
</template>

<script>
    export default {
        name: "AddReport",
        data() {
            return {
                label: 'ghbdtn',
                model: 'ghbdtn',
                picker: null,
                fromDateMenu: false,
                fromDateVal: "2019.07.04",
                minDate: "2019-07-04",
                maxDate: "2019-08-30"
            }
        }, computed: {
            computedDateFormatted () {
                return this.formatDate(this.date)
            },
            fromDateDisp() {
                return this.fromDateVal;
                // format date, apply validations, etc. Example below.
                // return this.fromDateVal ? this.formatDate(this.fromDateVal) : "";
            }
        },
        methods:{
            formatDate (date) {
                if (!date) return null

                const [year, month, day] = date.split('-')
                return `${month}/${day}/${year}`
            }, parseDate (date) {
                if (!date) return null

                const [month, day, year] = date.split('/')
                return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
            },
        }
    }
</script>

<style scoped>

</style>