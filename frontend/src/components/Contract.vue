<template>
    <div>
        <String
            label="계약명"
            v-model="value.title"
            :editMode="editMode"
        />
        <String
            label="계약단지명"
            v-model="value.houseName"
            :editMode="editMode"
        />
        <String
            label="계약단지위치"
            v-model="value.houseLocation"
            :editMode="editMode"
        />
        <String
            label="계약내용"
            v-model="value.content"
            :editMode="editMode"
        />
        <Date
            label="계약시작일자"
            v-model="value.contractAt"
            :editMode="editMode"
        />
        <Date
            label="계약종료일자"
            v-model="value.contractEndAt"
            :editMode="editMode"
        />
        <String
            label="계약자명"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="휴대폰번호"
            v-model="value.phoneNumber"
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
    name: 'Contract',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "contracts",
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
