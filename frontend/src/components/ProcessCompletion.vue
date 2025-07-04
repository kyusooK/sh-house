<template>

    <v-card outlined>
        <v-card-title>
            ProcessCompletion
        </v-card-title>

        <v-card-text>
            <Boolean label="IsCompletion" v-model="value.isCompletion" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="processCompletion"
            >
                ProcessCompletion
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
    name: 'ProcessCompletionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.isCompletion = false;
    },
    watch: {
    },
    methods: {
        processCompletion() {
            this.$emit('processCompletion', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

