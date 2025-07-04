<template>
    <div>
        <String
            label="단지명"
            v-model="value.houseName"
            :editMode="editMode"
        />
        <String
            label="단지 위치"
            v-model="value.houseLocation"
            :editMode="editMode"
        />
        <String
            label="계획서명"
            v-model="value.projectName"
            :editMode="editMode"
        />
        <String
            label="공급계획담당자"
            v-model="value.manager"
            :editMode="editMode"
        />
        <Number
            label="모집세대수"
            v-model="value.recruitmentCount"
            :editMode="editMode"
        />
        <HousingProjectId
            offline
            label="주택단지정보"
            v-model="value.housingProjectId"
            :editMode="editMode"
            @change="change"
        />
        <SupplyStatus
            offline
            label="공급계획처리상태"
            v-model="value.supplyStatus"
            :editMode="editMode"
            @change="change"
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
    name: 'HouseSupply',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "houseSupplies",
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
