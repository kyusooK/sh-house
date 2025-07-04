<template>
    <div>
        <String
            label="유지보수단지명"
            v-model="value.houseName"
            :editMode="editMode"
        />
        <String
            label="유지보수단지위치"
            v-model="value.houseLocation"
            :editMode="editMode"
        />
        <Boolean
            label="유지보수여부"
            v-model="value.isMaintenance"
            :editMode="editMode"
        />
        <Date
            label="유지보수시행날짜"
            v-model="value.maintenanceDate"
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
    name: 'Maintenance',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "maintenances",
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
