<template>

    <v-card outlined>
        <v-card-title>
            AcceptOrDecline
        </v-card-title>

        <v-card-text>
            <Boolean label="Acceptordecline" v-model="value.acceptordecline" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="acceptOrDecline"
            >
                AcceptOrDecline
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'AcceptOrDeclineCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.acceptordecline = false;
        },
        watch: {
        },
        methods: {
            acceptOrDecline() {
                this.$emit('acceptOrDecline', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

