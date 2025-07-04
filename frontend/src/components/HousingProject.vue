<template>
    <div>
        <String
            label="단지명"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="단지위치"
            v-model="value.location"
            :editMode="editMode"
        />
        <Date
            label="준공날짜"
            v-model="value.completionDate"
            :editMode="editMode"
        />
        <Boolean
            label="준공여부"
            v-model="value.isCompletion"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'HousingProject',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "housingProjects",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
