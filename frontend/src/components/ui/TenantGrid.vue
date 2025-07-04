<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="moveIn" class="contrast-primary-text" small color="primary" :disabled="!hasRole('입주민')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>입주
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="leave" class="contrast-primary-text" small color="primary" :disabled="!hasRole('입주민')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>퇴거
                </v-btn>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>입주단지명</th>
                        <th>입주위치</th>
                        <th>입주자명</th>
                        <th>입주자연락처</th>
                        <th>계약시작일자</th>
                        <th>계약종료일자</th>
                        <th>입주여부</th>
                        <th>퇴거여부</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="입주단지명">{{ val.houseName }}</td>
                            <td class="whitespace-nowrap" label="입주위치">{{ val.houseLocation }}</td>
                            <td class="whitespace-nowrap" label="입주자명">{{ val.tenantName }}</td>
                            <td class="whitespace-nowrap" label="입주자연락처">{{ val.tenantPhone }}</td>
                            <td class="whitespace-nowrap" label="계약시작일자">{{ val.contractStartAt }}</td>
                            <td class="whitespace-nowrap" label="계약종료일자">{{ val.contractEndAt }}</td>
                            <td class="whitespace-nowrap" label="입주여부">{{ val.isMoveIn }}</td>
                            <td class="whitespace-nowrap" label="퇴거여부">{{ val.isLeaving }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Tenant 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Tenant :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Tenant 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="입주단지명" v-model="selectedRow.houseName" :editMode="true"/>
                            <String label="입주위치" v-model="selectedRow.houseLocation" :editMode="true"/>
                            <String label="입주자명" v-model="selectedRow.tenantName" :editMode="true"/>
                            <String label="입주자연락처" v-model="selectedRow.tenantPhone" :editMode="true"/>
                            <Date label="계약시작일자" v-model="selectedRow.contractStartAt" :editMode="true"/>
                            <Date label="계약종료일자" v-model="selectedRow.contractEndAt" :editMode="true"/>
                            <Boolean label="입주여부" v-model="selectedRow.isMoveIn" :editMode="true"/>
                            <Boolean label="퇴거여부" v-model="selectedRow.isLeaving" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'tenantGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'tenants',
    }),
    watch: {
    },
    methods:{
        async moveIn(){
            try{
                var path = "moveIn".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, null)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','move in 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
            }catch(e){
                console.log(e)
            }
        },
        async leave(){
            try{
                var path = "leave".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, null)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','leave 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>