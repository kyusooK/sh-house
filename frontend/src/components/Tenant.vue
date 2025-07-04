<template>
    <div>
        <String
            label="입주단지명"
            v-model="value.houseName"
            :editMode="editMode"
        />
        <String
            label="입주위치"
            v-model="value.houseLocation"
            :editMode="editMode"
        />
        <String
            label="입주자명"
            v-model="value.tenantName"
            :editMode="editMode"
        />
        <String
            label="입주자연락처"
            v-model="value.tenantPhone"
            :editMode="editMode"
        />
        <Date
            label="계약시작일자"
            v-model="value.contractStartAt"
            :editMode="editMode"
        />
        <Date
            label="계약종료일자"
            v-model="value.contractEndAt"
            :editMode="editMode"
        />
        <Boolean
            label="입주여부"
            v-model="value.isMoveIn"
            :editMode="editMode"
        />
        <Boolean
            label="퇴거여부"
            v-model="value.isLeaving"
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
    name: 'Tenant',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "tenants",
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
