<template>
    <div>
        <String
            label="신청자명"
            v-model="value.applyName"
            :editMode="editMode"
        />
        <String
            label="신청자 휴대폰번호"
            v-model="value.phoneNumber"
            :editMode="editMode"
        />
        <String
            label="신청자 Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <String
            label="청약당첨단지명"
            v-model="value.house"
            :editMode="editMode"
        />
        <String
            label="쳥약당첨 단지 위치"
            v-model="value.location"
            :editMode="editMode"
        />
        <WinningStatus
            offline
            label="당첨상태"
            v-model="value.winningStatus"
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
    name: 'Winner',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "winners",
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
